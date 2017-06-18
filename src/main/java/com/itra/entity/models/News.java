package com.itra.entity.models;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
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
}