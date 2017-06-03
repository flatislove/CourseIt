package com.itra.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "manager")
    private List<Project> projectsManager = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Project> projects = new ArrayList<>();

    public User(long id) {
        this.id = id;
    }

    public User(String name, String nickname, String email, String password,String role) {
        this.email = email;
        this.name = name;
        this.nickname=nickname;
        this.password=password;
        this.role=new Role(role);
    }

    public User(String name, String nickname, String email, String password) {

    }

    public User(String subject, String s, List<SimpleGrantedAuthority> authorities) {
        this.name=subject;
        this.password=s;
        this.role=new Role(authorities.get(0).toString());
    }
    public User(String subject, String s) {
        this.name=subject;
        this.password=s;
        this.role=new Role("DEVELOPER");
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Role role = new Role("DEVELOPER");
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = new Role(role);
    }

    public String getRole() {
        return role.getName();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
