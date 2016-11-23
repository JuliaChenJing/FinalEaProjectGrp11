package com.grp11.Consumer;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.Domain.UserDomain;



@Controller
@RequestMapping("/consumer")
public class ConsumerCtrl {
	
	@Autowired
	private IConsumerService userService;
	
	
	@RequestMapping(value="/welcome")
	public String welcomePageDisplay( HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println("stupid app");
		System.out.println(username);
		UserDomain u = userService.getUserbyUserName(username);
		
		if(u != null)
			req.getSession().setAttribute("userId", u.getId());
		if(u != null && u.getRole().equals("USER")) {
			return "redirect:/products/";
		}
		return "welcome";
	}
	
	/*@RequestMapping(value= "/login",method = RequestMethod.GET)
	public String loginForm(){
		System.out.println("Reached here");
		return "login";
	}*/
	
	
	
	/*@RequestMapping(value= "/signUp", method = RequestMethod.GET)
	public String addConsumerForm(@ModelAttribute("newConsumer")UserDomain consumer){
		
		//System.out.println("Pramita");
		return "addConsumerForm";
	}*/
	
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
	
	@RequestMapping(value= "/deleteConsumer/{id}",method = RequestMethod.GET)
	 public ModelAndView deleteConsumer(@PathVariable Long id){  
		userService.deleteUser(id);
        return new ModelAndView("redirect:/consumer/showalluser");  
    }  
	
	 @RequestMapping(value="/updateConsumer/{id}",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("user") UserDomain consumer, @PathVariable("id") Long id){  
		 	consumer.setId(id);
		 	userService.update(consumer); 
	        return new ModelAndView("redirect:/showalluser");  
	 }  
	 
	@RequestMapping(value={"/showalluser"}, method = RequestMethod.GET)
	public String showAllUser(Model model){
		model.addAttribute("users", userService.getAllUser());
		
		return "customerList";
	}
	
	@RequestMapping(value= "/{id}/updateaddress", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomerAddress(@PathVariable("id") Long id, String street, String city, String zip){
		UserDomain user = userService.getUser(id);
		user.setCity(city);
		user.setZip(zip);
		user.setStreet(street);
		userService.update(user);
	}
	
	/*@RequestMapping(value={"","/showProduct"}, method = RequestMethod.GET)
	public ModelAndView  showWelcomeProduct(){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("products",productService.getallProducts());
		modelAndView.setViewName("welcomeProduct");
		return modelAndView;
	}*/
	
	
	
	

}
