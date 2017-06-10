package com.itra.controllers;

import com.itra.entity.models.News;
import com.itra.entity.repository.NewsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleController {
    public NewsRepository newsRepository;

    public SimpleController(NewsRepository newsRepository){
        this.newsRepository=newsRepository;
    };

    @GetMapping(path = "/login")
    public String mainViewMethod2(){
        return "main5_return";
    }
}