package com.itra.service.impl;

import com.itra.dto.NewsDto;
import com.itra.entity.models.News;
import com.itra.entity.repository.NewsRepository;
import com.itra.entity.repository.RoleRepository;
import com.itra.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private RoleRepository roleRepository;

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
    public News outDto(NewsDto newsDto){
        return new News(newsDto.getDescription(),newsDto.getText(),
                roleRepository.findByName(newsDto.getRole()));
    }

    @Override
    public NewsDto getByName(String name) {
        return new NewsDto(newsRepository.findByName(name));
    }

    @Override
    public News addNews(News news) {
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