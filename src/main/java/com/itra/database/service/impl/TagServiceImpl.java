package com.itra.database.service.impl;

import com.itra.database.models.Tag;
import com.itra.database.repository.TagRepository;
import com.itra.database.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getById(long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public Tag getByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Tag addTag(Tag tag) {
        Tag savedTag = tagRepository.saveAndFlush(tag);
        return savedTag;
    }

    @Override
    public void delete(long id) {
        tagRepository.delete(id);
    }

    @Override
    public Tag editTag(Tag tag) {
        return tagRepository.saveAndFlush(tag);
    }
}
