package com.grp11.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserCtrl {
	
	@RequestMapping(value= "/login",method = RequestMethod.GET)
	public String loginForm(){
		System.out.println("Reached here");
		return "login";
	}
	
	@RequestMapping(value= "/signUp", method = RequestMethod.GET)
	public String addConsumerForm(@ModelAttribute("newConsumer")ConsumerDomain consumer){
		return "addConsumerForm";
	}
	
	@RequestMapping(value= "/signUp", method = RequestMethod.POST)
	public String saveConsumerProfile(@ModelAttribute("newConsumer")ConsumerDomain consumer,BindingResult result){
		if(result.hasErrors()){
			return "addConsumerForm";
		}
		System.out.println("Database Save");
		return "successAdd";
	}
	

}
