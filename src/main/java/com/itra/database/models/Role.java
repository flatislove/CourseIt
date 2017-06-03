package com.itra.database.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

@Getter
@Setter
@Entity(name = "Role")
@Table(name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "role")
    private List<News> news = new ArrayList<>();

    public Role(){
        this.name="DEVELOPER";
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}