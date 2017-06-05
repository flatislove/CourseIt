package com.itra.entity.service;

import com.itra.entity.models.Role;
import java.util.List;

public interface RoleService {

    List<Role> getAll();
    Role getById(long id);
    Role getByName(String name);
    Role addNews(Role tag);
    void delete(long id);
    Role editNews(Role tag);
}
