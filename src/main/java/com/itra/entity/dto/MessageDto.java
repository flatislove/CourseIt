package com.itra.entity.dto;

import com.itra.entity.models.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDto {
    private long id;
    private Date date;
    private String text;
    private long authorId;

    public MessageDto(Message message){
        this.id=message.getId();
        this.date=message.getDate();
        this.text=message.getText();
        this.authorId=message.getAuthor().getId();
    }
}

