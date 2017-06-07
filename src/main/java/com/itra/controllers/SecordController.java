package com.itra.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecordController {
    @RequestMapping("/test")
    public String test(){
        return "tessdadaddadst";
    }
}
