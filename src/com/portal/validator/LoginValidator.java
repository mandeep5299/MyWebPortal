package com.portal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.portal.entity.Login;

@Component("loginValidator")
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Login.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", "login.username", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "login.password", "password is required");
	}


}
