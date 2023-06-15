package com.example.mvcdemo.domain.entities;

import com.example.mvcdemo.domain.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Role> roles;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column
    private String fullName;
    @Column
    private Integer age;

    public Level getLevel() {
        return level;
    }

    public User() {
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
