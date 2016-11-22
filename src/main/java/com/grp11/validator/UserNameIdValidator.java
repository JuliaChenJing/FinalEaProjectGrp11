package com.grp11.validator;

/*import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.grp11.Consumer.IConsumerService;

import waa.project.domain.Product;

import waa.project.service.ProductService;


public class UserNameIdValidator implements ConstraintValidator<Username, String>{
	
	@Autowired
	private IConsumerService consumerService;

	public void initialize(UserId constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		//try {
			product = productService.getProductbyId(value);
			
			
		//} catch (ProductNotFoundException e) {
		//	return true;
		//}
		
		if(product!= null) {
			return false;
		}
		
		return true;
	}
	
}
*/