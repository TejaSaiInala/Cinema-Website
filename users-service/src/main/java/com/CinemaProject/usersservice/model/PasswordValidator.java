package com.CinemaProject.usersservice.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
ConstraintValidator<ValidPassword, String> {

	
	@Override
    public void initialize(ValidPassword arg0) {
    }
	
	
	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext context) {
		//customizing validation messages
		return contactField != null 
		          && (contactField.length() > 4);
	}

	
}
