package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Newstag")
public class Newstag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long id_news;
    @NotNull
    private long id_tags;
    public Newstag(){};
    public Newstag(int id_news,int id_tags){
        this.id_news=id_news;
        this.id_tags=id_tags;
    }

    public long getId_news() {
        return id_news;
    }

    public void setId_news(long id_news) {
        this.id_news = id_news;
    }

    public long getId_tags() {
        return id_tags;
    }

    public void setId_tags(long id_tags) {
        this.id_tags = id_tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
