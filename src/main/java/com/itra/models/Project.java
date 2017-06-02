package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Project")
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    private String description;
    private String text;
    @NotNull
    private int status;
    @NotNull
    private int manager;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userproject",joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
        user.getProjects().add(this);
    }
    public void removeUser(User user){
        tags.remove(user);
        user.getProjects().remove(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tagproject",joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag){
        tags.add(tag);
        tag.getProjects().add(this);
    }
    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.getProjects().remove(this);
    }

    public Project(){};
    public Project(String name, int status, int manager){
        this.name=name;
        this.status=status;
        this.manager=manager;
    }
    public Project(String name, String description, int status, int manager){
        this.name=name;
        this.description=description;
        this.status=status;
        this.manager=manager;
    }
    public Project(String name, String description, String text, int status, int manager){
        this.name=name;
        this.description=description;
        this.text=text;
        this.status=status;
        this.manager=manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }
}
