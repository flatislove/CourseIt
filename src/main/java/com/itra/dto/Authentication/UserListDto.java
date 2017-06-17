package com.itra.dto.Authentication;

import com.itra.dto.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListDto implements Dto{
    private long id;
    private String nickname;
    private String role;
}
