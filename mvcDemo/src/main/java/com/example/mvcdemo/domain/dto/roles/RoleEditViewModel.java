package com.example.mvcdemo.domain.dto.roles;

public class RoleEditViewModel {
    private String roleName;

    public RoleEditViewModel() {
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleEditViewModel setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
