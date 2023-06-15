package com.example.mvcdemo.domain.dto.roles;

import com.example.mvcdemo.domain.enums.RoleName;

public class RoleViewModel {
    private Long id;
    private RoleName roleName;

    public RoleViewModel(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
