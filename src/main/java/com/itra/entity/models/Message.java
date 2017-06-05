package com.itra.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Message")
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long id;
    private Date date;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
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