package com.CinemaProject.usersservice.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
ConstraintValidator<ValidPhonenumber, String> {

	public void initialize(ValidPhonenumber arg0) {
    }
	
	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(contactField != null && contactField.matches("[0-9]+")
		          && (contactField.length() == 10))
		{
			return true;
		}
		return false;
	}

}
