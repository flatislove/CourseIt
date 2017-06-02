package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "News")
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String description;
    @NotNull
    private Date date;

    private String text;

    @NotNull
    private int role;

    public News(){};
    public News(String description,int role){
        this.description=description;
        this.date=new Date();
        this.role=role;
    }
    public News(String description,String text,int role){
        this.description=description;
        this.date=new Date();
        this.text=text;
        this.role=role;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "newstag",joinColumns = @JoinColumn(name = "news_id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag){
        tags.add(tag);
        tag.getNews().add(this);
    }
    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.getNews().remove(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
