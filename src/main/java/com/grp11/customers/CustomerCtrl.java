package com.grp11.customers;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.grp11.address.*;
import com.grp11.customers.*;
import com.grp11.shoppingCarts.*;
@Controller
public class CustomerCtrl {
	@Autowired
	private ICustomerService CustomerService;
	private static final Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllCustomers(Model model) {
		Collection<Customer> e = CustomerService.getCustomers();
//		e.forEach(System.out::println);
		return "home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addCustomer(@RequestBody Customer e) {
		CustomerService.saveCustomer(e);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{CustomerNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Customer e) {
		CustomerService.updateCustomer(e);
	}
	
	/*@RequestMapping(value = "/customer/{customerNumber}", method =	 RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public RedirectView deleteCustomer(@PathVariable("CustomerNumber") String CustomerNumber) {
		CustomerService.deleteCustomer(CustomerNumber);
		return new RedirectView("/customer", true);
	}*/
	
	
}