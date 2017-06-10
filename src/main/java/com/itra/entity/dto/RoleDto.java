package com.itra.entity.dto;

import com.itra.entity.models.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class RoleDto {
    private long id;
    private String name;

    public RoleDto(Role role){
        this.id=role.getId();
        this.name=role.getName();
    }
}
