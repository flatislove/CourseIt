package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "userproject")
public class UserProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long id_project;
    @NotNull
    private long id_user;

    public UserProject(){};
    public UserProject(int id_user,int id_project){
        this.id_user=id_user;
        this.id_project=id_project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_project() {
        return id_project;
    }

    public void setId_project(long id_project) {
        this.id_project = id_project;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
}
