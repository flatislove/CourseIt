package com.itra.entity.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.itra.authentication.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//240 elastic
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "User")
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "manager")
    private List<Project> projectsManager = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Message> authorMessage = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Project> projects = new ArrayList<>();

    public User(long id) {
        this.id = id;
    }

    public User(String name, String nickname, String email, String password) {
        this.email = email;
        this.name = name;
        this.nickname=nickname;
        this.password=password;
        this.role=new Role();
    }

    public User(String nickname, String password, UserRole role) {
        this.nickname=nickname;
        this.password=password;
        this.role=new Role(role.name());
    }

    public User(String subject, String s, List<SimpleGrantedAuthority> authorities) {
        this.name=subject;
        this.password=s;
        this.role=new Role();
    }
    public User(String subject, String s) {
        this.name=subject;
        this.password=s;
        this.role=new Role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Role role = new Role("DEVELOPER");
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
