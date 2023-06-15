package com.example.mvcdemo.domain.dto.users;

import com.example.mvcdemo.domain.dto.roles.RoleViewModel;
import com.example.mvcdemo.domain.enums.Level;

import java.util.Set;

public class UserViewModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<RoleViewModel> roles;
    private Level level;
    private String fullName;
    private Integer age;

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<RoleViewModel> getRoles() {
        return roles;
    }

    public UserViewModel setRoles(Set<RoleViewModel> roles) {
        this.roles = roles;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserViewModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleViewModel> getRole() {
        return roles;
    }

    public UserViewModel setRole(Set<RoleViewModel> roles) {
        this.roles = roles;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public UserViewModel setLevel(Level level) {
        this.level = level;
        return this;
    }

    public boolean isValid() {
        return this.id != null;
    }
}
