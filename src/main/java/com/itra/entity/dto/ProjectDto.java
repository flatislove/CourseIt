package com.itra.entity.dto;

import com.itra.entity.models.Project;
import com.itra.entity.service.impl.TagServiceImpl;
import com.itra.entity.service.impl.UserServiceImpl;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjectDto {
    private long id;
    private String name;
    private String description;
    private String text;
    private int status;
    private long manager;
    private ArrayList<Long> users;
    private ArrayList<Long> tags;

    public ProjectDto(Project project){
        this.id=project.getId();
        this.name=project.getName();
        this.description=project.getDescription();
        this.text=project.getText();
        this.status=project.getStatus();
        this.manager=project.getManager().getId();
        this.users=UserServiceImpl.getIdAll(project.getUsers());
        this.tags= TagServiceImpl.getIdAll(project.getTags());
    }
}
