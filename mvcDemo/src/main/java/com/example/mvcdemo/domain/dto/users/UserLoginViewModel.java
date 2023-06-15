package com.example.mvcdemo.domain.dto.users;

import com.example.mvcdemo.validation.checkUserExistence.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;

@ValidateLoginForm
public class UserLoginViewModel {
    @NotNull
    private String username;

    @NotNull
    private String password;

    public UserLoginViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginViewModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
