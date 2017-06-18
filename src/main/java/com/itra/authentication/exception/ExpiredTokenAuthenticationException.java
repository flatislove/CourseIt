package com.itra.authentication.exception;

public class ExpiredTokenAuthenticationException extends ArithmeticException {

    public ExpiredTokenAuthenticationException() {
        super("Authentication token is expired.");
    }
}
