package com.itra.entity.dto;

import com.itra.entity.models.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagDto {
    private long id;
    private String name;

    public TagDto(Tag tag){
        this.id=tag.getId();
        this.name=tag.getName();
    }
}
