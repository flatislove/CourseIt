package com.itra.controllers;

import com.itra.entity.models.Message;
import com.itra.entity.models.Role;
import com.itra.entity.repository.MessageRepository;
import com.itra.entity.repository.RoleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class JuneController {
    private RoleRepository roleRepository;
    private MessageRepository messageRepository;

    public JuneController(RoleRepository roleRepository,MessageRepository messageRepository){
        this.roleRepository=roleRepository;
        this.messageRepository=messageRepository;
    }
    @GetMapping("/role")
    @CrossOrigin(origins = "http://localhost:4200/role")
    public Collection<Role> listRole(){
        return roleRepository.findAll();
    }

    @GetMapping("/message")
    @CrossOrigin(origins = "http://localhost:4200/message")
    public Collection<Message> listMessage(){
        return messageRepository.findAll();
    }
}
