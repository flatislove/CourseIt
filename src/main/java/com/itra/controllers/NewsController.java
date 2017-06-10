package com.itra.controllers;

import com.itra.entity.dto.NewsDto;
import com.itra.entity.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/app")
public class NewsController {

    @Autowired
    NewsService newsService;

        @GetMapping(value = "/news")
        public List<NewsDto> getNews() {
        return newsService.getAll();
 }

        @GetMapping(value = "/news/{id}")
        public ResponseEntity<NewsDto> getNewsById(@PathVariable long id){
            NewsDto newsDto = newsService.getById(id);
            if(newsDto==null){
                return new ResponseEntity<NewsDto>(HttpStatus.NO_CONTENT);
            }
            else return new ResponseEntity<NewsDto>(newsDto,HttpStatus.OK);
        }
}
