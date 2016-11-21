package com.grp11.Consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class loginCtrl {
	
	@RequestMapping("/login")
	public String handleLogin(){
		return "login";

	}
}
