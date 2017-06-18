package com.itra.service.impl;

import com.itra.dto.TagDto;
import com.itra.entity.models.Tag;
import com.itra.entity.repository.TagRepository;
import com.itra.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<TagDto> getAll() {
        return this.toDto(tagRepository.findAll());
    }

    public List<TagDto> toDto(List<Tag> list){
        List<TagDto> listDto = new ArrayList<>();
        for (Tag tag: list){
            listDto.add(new TagDto(tag));
        }
        return listDto;
    }

    @Override
    public TagDto getById(long id) {
        return new TagDto(tagRepository.getOne(id));
    }

    @Override
    public TagDto getByName(String name) {

        return new TagDto(tagRepository.findByName(name));
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

    public static ArrayList<Long> getIdAll(List<Tag> tags){
        ArrayList<Long> listId = new ArrayList<>();
        for (Tag tag: tags){
            listId.add(tag.getId());
        }
        return listId;
    }
}