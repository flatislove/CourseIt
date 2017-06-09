package com.itra.entity.service;

import com.itra.entity.dto.MessageDto;
import com.itra.entity.models.Message;
import java.util.List;

public interface MessageService {
    List<MessageDto> getAll();
    MessageDto getById(long id);
    Message addMessage(Message tag);
    void delete(long id);
    Message editMessage(Message tag);
}