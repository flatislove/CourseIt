package com.itra.dto;

import com.itra.entity.models.Project;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjectDto implements Dto {
    private long id;
    private String name;
    private String description;
    private String markdown;
    private String text;
    private int status;
    private long manager;

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.markdown = project.getMarkdown();
        this.name = project.getName();
        this.description = project.getDescription();
        this.text = project.getText();
        this.status = project.getStatus();
        this.manager = project.getManager().getId();
    }
}
