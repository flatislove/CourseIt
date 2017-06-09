package com.itra.entity.service;

import com.itra.entity.dto.RoleDto;
import com.itra.entity.models.Role;
import java.util.List;

public interface RoleService {

    List<RoleDto> getAll();
    RoleDto getById(long id);
    RoleDto getByName(String name);
    Role addRole(Role role);
    void delete(long id);
    Role editRole(Role role);
}
