package com.grp11.stores;


import java.util.Collection;
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
@Controller
public class StoreCtrl {
	@Autowired
	private IStoreService StoreService;
	private static final Logger logger = LoggerFactory.getLogger(StoreCtrl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllStores(Model model) {
		Collection<Store> e = StoreService.getStore();
//		e.forEach(System.out::println);
		return "home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addStore(@RequestBody Store e) {
		StoreService.saveStore(e);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{StoreNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Store e) {
		StoreService.updateStore(e);
	}
	
	/*@RequestMapping(value = "/customer/{customerNumber}", method =	 RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public RedirectView deleteCustomer(@PathVariable("StoreNumber") String StoreNumber) {
		StoreService.deleteStore(StoreNumber);
		return new RedirectView("/customer", true);
	}*/
	
	
}
