package com.itra.database.service;


import com.itra.database.models.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag getById(long id);
    Tag getByName(String name);
    Tag addTag(Tag tag);
    void delete(long id);
    Tag editTag(Tag tag);
}