package com.itra.service.impl;

import com.itra.dto.MessageDto;
import com.itra.entity.models.Message;
import com.itra.entity.repository.MessageRepository;
import com.itra.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<MessageDto> getAll() {
        return this.toDto(messageRepository.findAll());
    }

    public List<MessageDto> toDto(List<Message> list){
        List<MessageDto> listDto = new ArrayList<>();
        for (Message message: list){
            listDto.add(new MessageDto(message));
        }
        return listDto;
    }

    @Override
    public MessageDto getById(long id) {
        return new MessageDto(messageRepository.findOne(id));
    }

    @Override
    public Message addMessage(Message tag) {
        Message savedMessage = messageRepository.saveAndFlush(tag);
        return savedMessage;
    }

    @Override
    public void delete(long id) {
        messageRepository.delete(id);
    }

    @Override
    public Message editMessage(Message tag) {
        return messageRepository.saveAndFlush(tag);
    }
}
