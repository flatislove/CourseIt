package com.itra.entity.service.impl;

import com.itra.entity.models.Tag;
import com.itra.entity.repository.TagRepository;
import com.itra.entity.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
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