package com.itra.entity.service;

import com.itra.entity.models.News;
import java.util.List;

public interface NewsService {
    List<News> getAll();
    News getById(long id);
    News getByName(String name);
    News addNews(News tag);
    void delete(long id);
    News editNews(News tag);
}
