package com.itra.entity.models;

import lombok.*;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity(name = "Message")
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long id;
    private Date date;
    private String text;
    //@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    //@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    public Message(Date date, String text, Project project,User author){
        this.date=date;
        this.text=text;
        this.project=project;
        this.author=author;
    }

    public Message(String text,Project project,User author){
        this.date=new Date();
        this.text=text;
        this.project=project;
        this.author=author;
    }
}