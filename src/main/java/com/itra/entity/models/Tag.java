package com.itra.entity.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity(name = "Tag")
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<News> news = new ArrayList<>();

    @ManyToMany(mappedBy = "tags")
    private List<Project> projects = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }
}