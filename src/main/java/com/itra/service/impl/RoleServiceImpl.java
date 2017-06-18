package com.itra.service.impl;

import com.itra.dto.RoleDto;
import com.itra.entity.models.Role;
import com.itra.entity.repository.RoleRepository;
import com.itra.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getByIdRole(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<RoleDto> getAll() {
        return this.toDto(roleRepository.findAll());
    }

    public List<RoleDto> toDto(List<Role> list){
        List<RoleDto> listDto = new ArrayList<>();
        for (Role role: list){
            listDto.add(new RoleDto(role));
        }
        return listDto;
    }


    @Override
    public RoleDto getById(long id) {
        return new RoleDto(roleRepository.findOne(id));
    }

    @Override
    public RoleDto getByName(String name) {
        return new RoleDto(roleRepository.findByName(name));
    }

    @Override
    public Role addRole(Role tag) {
        Role savedRole = roleRepository.saveAndFlush(tag);
        return savedRole;
    }

    @Override
    public void delete(long id) {
        roleRepository.delete(id);
    }

    @Override
    public Role editRole(Role tag) {
        return roleRepository.saveAndFlush(tag);
    }
}