package com.itra.entity.service;

import com.itra.entity.models.Tag;
import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag getById(long id);
    Tag getByName(String name);
    Tag addTag(Tag tag);
    void delete(long id);
    Tag editTag(Tag tag);
}