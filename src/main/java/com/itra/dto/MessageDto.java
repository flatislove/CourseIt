package com.itra.dto;

import com.itra.entity.models.Message;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MessageDto implements Dto {
    private Date date;
    private String text;
    private long projectId;
    private long authorId;

    public MessageDto(Message message) {
        this.projectId = message.getProject().getId();
        this.date = message.getDate();
        this.text = message.getText();
        this.authorId = message.getAuthor().getId();
    }
}

