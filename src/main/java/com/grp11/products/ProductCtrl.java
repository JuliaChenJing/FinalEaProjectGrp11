package com.grp11.products;

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
@RequestMapping("/products")
public class ProductCtrl {
	@Autowired
	private IProductService productService;
	/*@Autowired
	private ISupplierService supplierService;*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllProductsFromAllUser(Model model) {
		model.addAttribute("allProducts", productService.getAllProduct());
		return "home2";
	}

	@RequestMapping(value = "/{SupplierId}/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addConsumer(@RequestBody ProductDomain Product, @PathVariable("SupplierId") long SupplierId) {
		//	TODO: add it after Supplier is complete
		/*SupplierDomain s = supplierService.getStore(SupplierId);
		Product.setSupplier(s);*/
		productService.createProduct(Product);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{SupplierId}/{ProductId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String updateConsumer(@RequestBody ProductDomain Product, @PathVariable("SupplierId") long SupplierId) {
//		TODO: add it after Supplier is complete
		/*SupplierDomain s = supplierService.getStore(SupplierId);
		Product.setSupplier(s);*/
		productService.updateProduct(Product);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteConsumer(@RequestBody ProductDomain Product) {
		
		productService.deleteProduct(Product.getId());
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{supplierId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllProductsForSpecificUser(@PathVariable("UserId") long supplierId, Model model) {
		model.addAttribute("allProducts", productService.getAllProductForSupplier(supplierId));
		return "home2";
	}

}