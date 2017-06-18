package com.itra.service.impl;

import com.itra.dto.MessageDto;
import com.itra.entity.models.Message;
import com.itra.entity.repository.MessageRepository;
import com.itra.entity.repository.ProjectRepository;
import com.itra.entity.repository.UserRepository;
import com.itra.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    public List<Message> getAll() {
        return this.messageRepository.findAll();
    }


    public Message getById(long id) {
        return messageRepository.findOne(id);
    }

    public Message addMessage(Message message) {
        Message savedMessage = messageRepository.saveAndFlush(message);
        return savedMessage;
    }

    public void deleteMessage(long id) {
        messageRepository.delete(id);
    }

    public Message editMessage(Message tag) {
        return messageRepository.saveAndFlush(tag);
    }

    public List<Message> getAllMessagesOfProject(long id_project) {
        return messageRepository.getAllByProject(id_project);
    }

    public Message outDto(MessageDto messageDto) {
        return new Message(messageDto.getDate(),messageDto.getText(),
                this.projectRepository.findById(messageDto.getProjectId()),
                this.userRepository.findOne(messageDto.getAuthorId()));
    }

    public List<MessageDto> listMessageToDto(List<Message> list){
        List<MessageDto> listDto = new ArrayList<>();
        for (Message message: list){
            listDto.add(new MessageDto(message));
        }
        return listDto;
    }
}
