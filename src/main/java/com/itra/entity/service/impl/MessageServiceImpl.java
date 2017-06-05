package com.itra.entity.service.impl;

import com.itra.entity.models.Message;
import com.itra.entity.repository.MessageRepository;
import com.itra.entity.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message getById(long id) {
        return messageRepository.findOne(id);
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
