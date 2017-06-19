package com.itra.service;

import com.itra.dto.NewsDto;
import com.itra.entity.models.News;
import java.util.List;

public interface NewsService {
    List<NewsDto> getAll();
    NewsDto getById(long id);
    NewsDto getByName(String name);
    News addNews(News tag);
    void delete(long id);
    News editNews(News tag);
    News outDto(NewsDto newsDto);
}
