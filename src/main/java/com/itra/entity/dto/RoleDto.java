package com.itra.entity.dto;

import com.itra.entity.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDto {
    private long id;
    private String name;

    public RoleDto(Role role){
        this.id=role.getId();
        this.name=role.getName();
    }
}
