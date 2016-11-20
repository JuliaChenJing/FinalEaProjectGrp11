package com.grp11.suppliers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.suppliers.ISupplierService;
import com.grp11.suppliers.SupplierDomain;
@Controller
@RequestMapping("/suppliers")
public class SupplierCtrl {
	@Autowired
	private ISupplierService SupplierService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllSuppliers(Model model) {
		model.addAttribute("allSuppliers", SupplierService.getAllSupplier());
		return "home2";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String addSupplier() {
		return "addSupplier";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addSupplier(@ModelAttribute SupplierDomain Supplier) {
		System.out.println("inside supplier add");
		SupplierService.createSupplier(Supplier);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{SupplierId}/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String updateSupplier(@RequestBody SupplierDomain Supplier, @PathVariable("SupplierId") long SupplierId) {
		SupplierService.updateSupplier(Supplier);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteSupplier(@RequestBody SupplierDomain Supplier) {
		
		SupplierService.deleteSupplier(Supplier.getId());
		return "redirect:/home2";
	}

}