package com.itra.controllers;

import com.itra.entity.models.News;
import com.itra.entity.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping(value = "/news")
    @CrossOrigin(origins = "http://localhost:4200/news")
    public News getNews() {
        return newsService.getById(4L);
    }
}
