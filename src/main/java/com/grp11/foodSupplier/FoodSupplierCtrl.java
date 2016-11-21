package com.grp11.foodSupplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grp11.Domain.SuppliersDomain;

@Controller
@RequestMapping("/supplier")
public class FoodSupplierCtrl {
	
	@Autowired
	private IFoodSupplierService foodSupplierService;
	
	@RequestMapping(value= "/addsupplier")
	public String addSupplierForm(@ModelAttribute("newSupplier")SuppliersDomain supplier){
		return "addSupplier";
	}
	
	
	@RequestMapping(value= "/addsupplier", method = RequestMethod.POST)
	public String saveConsumerProfile(@ModelAttribute("newSupplier")SuppliersDomain supplier ){
		
		System.out.println("Database Save");
		System.out.println(supplier);
		foodSupplierService.addSupplier(supplier);
		return "addSupplier";
	}
}
