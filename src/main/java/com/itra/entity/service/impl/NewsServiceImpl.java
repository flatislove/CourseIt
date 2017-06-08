package com.itra.entity.service.impl;

import com.itra.entity.models.News;
import com.itra.entity.repository.NewsRepository;
import com.itra.entity.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Stream;

@Service
public class NewsServiceImpl implements NewsService {

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

//    @Override
//    public void run(String... args) throws Exception {
//        Stream.of("NewsStream","NewsStream2","NewsStream3","NewsStream4","NewsStream5","NewsStream6").forEach(name->
//        newsRepository.saveAndFlush(new News(name)));
//        newsRepository.findAll().forEach(System.out::println);
//
//    }
}