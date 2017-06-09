package com.itra.entity.dto;

import com.itra.entity.models.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
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
