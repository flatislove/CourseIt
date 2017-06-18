package com.itra.dto;

import com.itra.entity.models.Message;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MessageDto implements Dto{
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

