package com.example.mvcdemo.helpers;

import com.example.mvcdemo.domain.dto.roles.RoleViewModel;
import com.example.mvcdemo.domain.enums.RoleName;

import java.util.Set;

public class LoggedUser {
    private Long id;
    private String username;
    private Set<RoleViewModel> roles;

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<RoleViewModel> getRoles() {
        return roles;
    }

    public LoggedUser setRoles(Set<RoleViewModel> roles) {
        this.roles = roles;
        return this;
    }

    public void clearFields() {
        id = null;
        roles = null;
        username = null;
    }

    public boolean isAdmin(){
        return roles.stream().anyMatch(r -> r.getRoleName().equals(RoleName.ADMIN));
    }
}
