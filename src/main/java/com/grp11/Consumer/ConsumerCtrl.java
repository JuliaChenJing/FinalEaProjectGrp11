package com.grp11.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grp11.Domain.UserDomain;

@Controller
@RequestMapping("/consumer")
public class ConsumerCtrl {
	
	@Autowired
	private IConsumerService userService;
	
	@RequestMapping(value="/welcome")
	public String welcomePageDisplay(){
		return "welcome";
	}
	
	/*@RequestMapping(value= "/login",method = RequestMethod.GET)
	public String loginForm(){
		System.out.println("Reached here");
		return "login";
	}*/
	
	@RequestMapping(value= "/signUp", method = RequestMethod.GET)
	public String addConsumerForm(@ModelAttribute("newConsumer")UserDomain consumer){
		
		//System.out.println("Pramita");
		return "addConsumerForm";
	}
	
	@RequestMapping(value= "/signUp", method = RequestMethod.POST)
	public String saveConsumerProfile(@Valid @ModelAttribute("newConsumer")UserDomain consumer,BindingResult result){
		if(result.hasErrors()){
			return "addConsumerForm";
		}
		
		System.out.println("Database Save");
		System.out.println(consumer.getFirstName());
		
		userService.addConsumer(consumer);		
		return "successAdd";
	}
	
	@RequestMapping(value= "/deleteConsumer/{id}")
	public void deleteCustomerProfile(@PathVariable("id") Long id){
		userService.deleteUser(id);
		
	}
	
	
	
	

}
