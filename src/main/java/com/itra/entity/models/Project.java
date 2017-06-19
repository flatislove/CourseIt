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
@Entity(name = "Project")
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private long id;
    @NotNull
    private String name;
    private String description;
    private String text;
    private String markdown;
    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User manager;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userproject", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Message> projectMessage = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        user.getProjects().add(this);
    }

    public void removeUser(User user) {
        tags.remove(user);
        user.getProjects().remove(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tagproject", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getProjects().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getProjects().remove(this);
    }

    public Project(String name, int status, User manager) {
        this.name = name;
        this.status = status;
        this.manager = manager;
    }

    public Project(String name, String description, int status, User manager) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.manager = manager;
    }

    public Project(String name, String description, String text, String markdown, int status, User manager) {
        this.name = name;
        this.markdown = markdown;
        this.description = description;
        this.text = text;
        this.status = status;
        this.manager = manager;
    }

    public Project(long id, String name, String description, String text, String markdown, int status, User manager) {
        this.id = id;
        this.name = name;
        this.markdown = markdown;
        this.description = description;
        this.text = text;
        this.status = status;
        this.manager = manager;
    }
}