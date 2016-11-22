package com.grp11.Consumer;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
=======
>>>>>>> 6f9b56950f71bb2dcbf32cb4faa5a3103020f818
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	/*@RequestMapping(value= "/signUp", method = RequestMethod.GET)
	public String addConsumerForm(@ModelAttribute("newConsumer")UserDomain consumer){
		
		//System.out.println("Pramita");
		return "addConsumerForm";
	}*/
	
	@RequestMapping(value= "/signUp", method = RequestMethod.POST)
	public String saveConsumerProfile(/*@Valid*/ @ModelAttribute("newConsumer")UserDomain consumer/*,BindingResult result*/){
		/*if(result.hasErrors()){
			return "addConsumerForm";
		}*/
		
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
	    public ModelAndView editsave(@ModelAttribute("user") UserDomain consumer){  
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
