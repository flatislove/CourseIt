package com.itra.entity.service.impl;

import com.itra.entity.dto.NewsDto;
import com.itra.entity.models.News;
import com.itra.entity.repository.NewsRepository;
import com.itra.entity.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsDto> getAll() {
        return this.toDto(newsRepository.findAll());
    }

    public List<NewsDto> toDto(List<News> list){
        List<NewsDto> listDto = new ArrayList<>();
        for (News news: list){
            listDto.add(new NewsDto(news));
        }
        return listDto;
    }

    @Override
    public NewsDto getById(long id) {
        return new NewsDto(newsRepository.findOne(id));
    }

    @Override
    public NewsDto getByName(String name) {
        return new NewsDto(newsRepository.findByName(name));
    }

    @Override
    public News addNews(News tag) {
        News savedNews = newsRepository.saveAndFlush(tag);
        return savedNews;
    }

    @Override
    public void delete(long id) {
        newsRepository.delete(id);
    }

    @Override
    public News editNews(News tag) {
        return newsRepository.saveAndFlush(tag);
    }


}