package com.itra.entity.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Data
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
}