package com.grp11.Consumer;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grp11.Domain.UserDomain;

@Controller

public class loginCtrl {
	
	@RequestMapping("/login")
	public String handleLogin(){
		return "login";

	}
	@RequestMapping(value= "/signUp", method = RequestMethod.GET)
	public String addConsumerForm(@ModelAttribute("newConsumer")UserDomain consumer){
		
		//System.out.println("Pramita");
		return "addConsumerForm";
	}
	@RequestMapping(value = "/loginchecker")
	public String success(Model model, Principal user) {
		System.out.println("****************************************success");
		String username= user.getName();
		System.out.println(username);
		return "home";
	}
	
}
