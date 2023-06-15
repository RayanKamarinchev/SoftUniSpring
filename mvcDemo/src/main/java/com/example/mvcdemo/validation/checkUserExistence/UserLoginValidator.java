package com.example.mvcdemo.validation.checkUserExistence;

import com.example.mvcdemo.domain.dto.users.UserLoginViewModel;
import com.example.mvcdemo.domain.dto.users.UserViewModel;
import com.example.mvcdemo.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginViewModel> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginViewModel userLoginViewModel, ConstraintValidatorContext constraintValidatorContext) {
        UserViewModel user =userService.findByUsername(userLoginViewModel.getUsername());
        return user != null && user.getPassword().equals(userLoginViewModel.getPassword());
    }
}
