package com.itra.entity.service;

import com.itra.entity.dto.TagDto;
import com.itra.entity.models.Tag;
import java.util.List;

public interface TagService {
    List<TagDto> getAll();
    TagDto getById(long id);
    TagDto getByName(String name);
    Tag addTag(Tag tag);
    void delete(long id);
    Tag editTag(Tag tag);
}