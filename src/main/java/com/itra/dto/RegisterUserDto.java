package com.itra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("role")
    private String role;

    public RegisterUserDto(String nickname,String name,String email, String password){
        this.nickname=nickname;
        this.name=name;
        this.email=email;
        this.password=password;
    }
}
