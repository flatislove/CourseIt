package com.itra.authentication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itra.authentication.exception.InvalidTokenAuthenticationException;
import com.itra.authentication.model.TokenPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthenticationHelper {
    public static final String AUTHENTICATION_HEADER = "Authorization";
    public static final String AUTHENTICATION_PARAM = "auth";
    private final String SECRET = "secret";

    private Long tokenExpirationTime = 3600L;

    private final ObjectMapper objectMapper;

    public String generateToken(final Long userId) {
        try {
            TokenPayload payoad = new TokenPayload(userId, Instant.now().getEpochSecond() + this.tokenExpirationTime);
            String token = this.objectMapper.writeValueAsString(payoad);
            return JwtHelper.encode(token, new MacSigner(SECRET)).getEncoded();
        } catch (JsonProcessingException exception) {
            throw new InternalAuthenticationServiceException("Error create token", exception);
        }
    }

    public TokenPayload decodeToken(final String token) {
        if (Objects.isNull(token)) {
            throw new InvalidTokenAuthenticationException("Token is null.");
        }
        Jwt jwt = JwtHelper.decode(token);
        try {
            jwt.verifySignature(new MacSigner(SECRET));
        } catch (Exception exception) {
            throw new InvalidTokenAuthenticationException("Invalid token", exception);
        }
        String claims = jwt.getClaims();
        TokenPayload tokenPayload;
        try {
            tokenPayload = this.objectMapper.readValue(claims, TokenPayload.class);
        } catch (IOException exception) {
            throw new InvalidTokenAuthenticationException("Token reading failed.", exception);
        }
        return tokenPayload;
    }
}