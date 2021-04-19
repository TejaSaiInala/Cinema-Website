package com.CinemaProject.usersservice.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ValidPhonenumber {
    String message() default "Invalid Phone Number/ Enter only numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
