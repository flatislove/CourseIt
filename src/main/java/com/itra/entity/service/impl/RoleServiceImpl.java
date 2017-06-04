package com.itra.entity.service.impl;

import com.itra.entity.models.Role;
import com.itra.entity.repository.RoleRepository;
import com.itra.entity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role addNews(Role tag) {
        Role savedRole = roleRepository.saveAndFlush(tag);
        return savedRole;
    }

    @Override
    public void delete(long id) {
        roleRepository.delete(id);
    }

    @Override
    public Role editNews(Role tag) {
        return roleRepository.saveAndFlush(tag);
    }
}