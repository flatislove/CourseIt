package com.itra.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    public News(String description){
        this.description=description;
        this.date=new Date();
        this.role=new Role("DEVELOPER");
    }

    public News(String description,String text){
        this.description=description;
        this.date=new Date();
        this.text=text;
        this.role=new Role("DEVELOPER");
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "newstag",joinColumns = @JoinColumn(name = "news_id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

//    public void addTag(Tag tag){
//        tags.add(tag);
//        tag.getNews().add(this);
//    }
//
//    public void removeTag(Tag tag){
//        tags.remove(tag);
//        tag.getNews().remove(this);
//    }
}