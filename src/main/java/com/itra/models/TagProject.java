package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tagproject")
public class TagProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private int id_project;
    @NotNull
    private int id_tag;

    public TagProject(){};
    public TagProject(int id_tag,int id_project){
        this.id_project=id_project;
        this.id_tag=id_tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }
}
