package com.itra.dto;

import com.itra.entity.models.Tag;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TagDto implements Dto{
    private long id;
    private String name;

    public TagDto(Tag tag){
        this.id=tag.getId();
        this.name=tag.getName();
    }
}
