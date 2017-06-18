package com.itra.authentication.service;

import com.itra.authentication.handler.RestAuthenticationFailureHandler;
import com.itra.authentication.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter(final AuthenticationManager authenticationManager){
        super(httpServletRequest -> true);
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        try{
            String token = Optional.ofNullable(httpServletRequest.getHeader(AuthenticationHelper.AUTHENTICATION_HEADER))
                    .map(header->header.substring(7)).orElse(null);

            if (Objects.isNull(token)){
                throw new BadCredentialsException("Token not found in request's header");
            }
            JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(token);

            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (AuthenticationException exception){
            unsuccessfulAuthentication(httpServletRequest,httpServletResponse,exception);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest httpServletRequest,
                                            final HttpServletResponse httpServletResponse,
                                            final FilterChain filterChain,
                                            final Authentication authentication) throws IOException,ServletException{
        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (this.eventPublisher!=null){
            this.eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authentication,this.getClass()));
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
