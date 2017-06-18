package com.itra.dto;

import com.itra.entity.models.News;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class NewsDto implements Dto{
    private long id;
    private String description;
    private Date date;
    private String text;
    private long role;

    public NewsDto(News news){
        this.id=news.getId();
        this.description=news.getDescription();
        this.date=news.getDate();
        this.text=news.getText();
        this.role=news.getRole().getId();
    }
}
