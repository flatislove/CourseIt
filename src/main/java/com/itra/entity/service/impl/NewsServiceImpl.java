package com.itra.entity.service.impl;

import com.itra.entity.models.News;
import com.itra.entity.repository.NewsRepository;
import com.itra.entity.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public News getById(long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public News getByName(String name) {
        return newsRepository.findByName(name);
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