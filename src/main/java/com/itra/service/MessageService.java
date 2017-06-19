package com.itra.service;

import com.itra.dto.MessageDto;
import com.itra.entity.models.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAll();

    Message getById(long id);

    Message addMessage(Message message);

    void deleteMessage(long id);

    Message editMessage(Message tag);

    List<Message> getAllMessagesOfProject(long id_project);

    Message outDto(MessageDto messageDto);

    List<MessageDto> listMessageToDto(List<Message> list);

}