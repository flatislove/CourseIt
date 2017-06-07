package com.itra.controllers;

import com.itra.entity.models.Role;
import com.itra.entity.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class JuneController {
    private RoleRepository roleRepository;

    public JuneController(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    @GetMapping("/role")
    Collection<Role> listRole(){
        return roleRepository.findAll();
    }
}
