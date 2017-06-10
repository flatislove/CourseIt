package com.itra.controllers;

import com.itra.entity.dto.MessageDto;
import com.itra.entity.dto.RoleDto;
import com.itra.entity.models.Message;
import com.itra.entity.models.Role;
import com.itra.entity.repository.MessageRepository;
import com.itra.entity.repository.RoleRepository;
import com.itra.entity.service.MessageService;
import com.itra.entity.service.RoleService;
import com.itra.entity.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
@CrossOrigin
@RestController
public class JuneController {
    private RoleService roleService;
    private MessageService messageService;

    public JuneController(RoleService roleService, MessageService messageService){
        this.roleService=roleService;
        this.messageService=messageService;
    }
    @GetMapping("/role")
    public Collection<RoleDto> listRole(){
        return roleService.getAll();
    }

    @GetMapping("/rrr")
    public ResponseEntity<RoleDto> getasd() {
        return ResponseEntity.ok(roleService.getById(2L));
    }

    @GetMapping("/message")
    //@CrossOrigin(origins = "http://localhost:4200/message")
    public Collection<MessageDto> listMessage(){
        return messageService.getAll();
    }
}
