package com.itra.authentication;

import com.itra.authentication.exception.ExpiredTokenAuthenticationException;
import com.itra.authentication.exception.InvalidTokenAuthenticationException;
import com.itra.authentication.model.JwtAuthenticationToken;
import com.itra.authentication.model.JwtUserDetails;
import com.itra.authentication.model.TokenPayload;
import com.itra.authentication.service.AuthenticationHelper;
import com.itra.entity.models.User;
import com.itra.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private static final long MILLIS_IN_SECOND = 1000L;
    private final UserRepository userRepository;
    private final AuthenticationHelper authenticationHelper;

    @Override
    public Authentication authenticate(final Authentication authentication) {
        String token = StringUtils.trimToNull((String) authentication.getCredentials());

        TokenPayload tokenPayload = authenticationHelper.decodeToken(token);

        checkIsExpired(tokenPayload.getExp());

        Long userEntityId = tokenPayload.getUserId();
        if (Objects.isNull(userEntityId)) {
            throw new InvalidTokenAuthenticationException("Token does not contain a user id.");
        }

        User user = userRepository.findOne(userEntityId);
        if (Objects.isNull(user)) {
            throw new InvalidTokenAuthenticationException("Token does not contain existed user id.");
        }

        JwtUserDetails userDetails = new JwtUserDetails(user);
        return new JwtAuthenticationToken(userDetails);
    }

    private void checkIsExpired(final Long tokenExpirationTime) {
        if ((System.currentTimeMillis() / MILLIS_IN_SECOND) > tokenExpirationTime) {
            throw new ExpiredTokenAuthenticationException();
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}