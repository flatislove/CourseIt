package com.itra.entity.dto;

import com.itra.entity.models.User;
import com.itra.entity.service.impl.ProjectServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto{
    private long id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String photo;
    private long role;
    private ArrayList<Long> projects;

    public UserDto(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.nickname=user.getNickname();
        this.photo=user.getPhoto();
        this.role=user.getRole();
        this.projects= ProjectServiceImpl.getIdAll(user.getProjects());
    }

}
