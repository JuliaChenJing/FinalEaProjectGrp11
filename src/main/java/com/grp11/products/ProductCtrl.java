package com.grp11.products;

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
public class ProductCtrl {
	@Autowired
	private IProductService ProductService;
	private static final Logger logger = LoggerFactory.getLogger(ProductCtrl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllProducts(Model model) {
		Collection<Product> e = ProductService.getProduct();
//		e.forEach(System.out::println);
		return "home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addProduct(@RequestBody Product e) {
		ProductService.saveProduct(e);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{ProductNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Product e) {
		ProductService.updateProduct(e);
	}
	
	/*@RequestMapping(value = "/customer/{customerNumber}", method =	 RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public RedirectView deleteCustomer(@PathVariable("ProductNumber") String ProductNumber) {
		ProductService.deleteProduct(ProductNumber);
		return new RedirectView("/customer", true);
	}*/
	
	
}