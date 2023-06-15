package com.example.mvcdemo.validation.passwordMatcher;

import com.example.mvcdemo.domain.dto.users.UserRegisterViewModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcher
        implements ConstraintValidator<PasswordMatch, UserRegisterViewModel> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterViewModel userRegisterViewModel, ConstraintValidatorContext constraintValidatorContext) {
        if (userRegisterViewModel.getPassword() != null &&
        userRegisterViewModel.getPassword().equals(userRegisterViewModel.getConfirmPassword())) {
            return true;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterViewModel.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
