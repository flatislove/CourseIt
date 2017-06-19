package com.itra.dto;

import com.itra.entity.models.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserDto implements Dto {
    private long id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String photo;
    private String role;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.photo = user.getPhoto();
        this.role = user.getRole().getName();
    }
//    public UserDto(User user) {
//        this.nickname = user.getNickname();
//        this.name = user.getName();
//        this.email=user.getEmail();
//        this.password = user.getPassword();
//    }
}