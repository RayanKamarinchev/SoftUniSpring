package com.example.mvcdemo.validation.checkUserExistence;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UserLoginValidator.class)
public @interface ValidateLoginForm {
    String message() default "Ivalid login";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
