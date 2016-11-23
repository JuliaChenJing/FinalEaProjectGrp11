package com.grp11.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.grp11.Consumer.ConsumerServiceImpl;
import com.grp11.Domain.UserDomain;




public class UsernameValidator implements ConstraintValidator<Username, String>{
	
	@Autowired
	private ConsumerServiceImpl consumerService;

	public void initialize(Username constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String Username, ConstraintValidatorContext context) {
		UserDomain user;
		try {
		
		user = consumerService.getUserbyUserName(Username);
		
		System.out.println(user);
		}
		catch (Exception e) {
			return true;
		}
		if(user != null){
			
			return false;
		}
		else{
			
			return true;
		}	
		
	}
	
}
