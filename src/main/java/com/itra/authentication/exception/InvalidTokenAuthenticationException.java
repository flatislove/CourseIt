package com.itra.authentication.exception;


import org.springframework.security.core.AuthenticationException;

public class InvalidTokenAuthenticationException extends AuthenticationException {
    public InvalidTokenAuthenticationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public InvalidTokenAuthenticationException(final String message) {
        super(message);
    }
}
