package com.itra.authentication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenPayload {
    private long userId;
    private long exp;

    public TokenPayload(final long userId, final long exp) {
        this.userId = userId;
        this.exp = exp;
    }
}
