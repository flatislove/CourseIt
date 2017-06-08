package com.itra.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Tag")
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;

    @JsonIgnore
    //@JsonBackReference
    @ManyToMany(mappedBy = "tags")
    private List<News> news = new ArrayList<>();

    @JsonIgnore
    //@JsonBackReference
    @ManyToMany(mappedBy = "tags")
    private List<Project> projects = new ArrayList<>();

    public Tag(String name){
        this.name=name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<News> getNews() {
        return news;
    }
}