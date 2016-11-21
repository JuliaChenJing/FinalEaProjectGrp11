package com.grp11.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.category.ICategoryService;
import com.grp11.suppliers.ISupplierService;
import com.grp11.suppliers.SupplierDomain;
@Controller
@RequestMapping("/products")
public class ProductCtrl {
	@Autowired
	private IProductService productService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ICategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllProducts(Model model) {
		model.addAttribute("allProducts", productService.getAllProduct());
		return "home2";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String addNewProduct(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("suppliers", supplierService.getAllSupplier());
		return "addProduct";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addProduct(ProductDomain Product, BindingResult result, Long supplierId, Long categoryId) {
		Product.setCategory(categoryService.getCategory(categoryId));
		Product.setSupplier(supplierService.getSupplier(supplierId));
		productService.createProduct(Product);
		return "redirect:/orders/";
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String newProduct(Model model, @PathVariable("productId") long productId) {
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("suppliers", supplierService.getAllSupplier());
		model.addAttribute("product", productService.getProduct(productId));
		return "updateProduct";
	}
	
	@RequestMapping(value = "/{ProductId}/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String updateProduct(ProductDomain Product, BindingResult result, @PathVariable("ProductId") long ProductId, Long supplierId, Long categoryId) {
		Product.setCategory(categoryService.getCategory(categoryId));
		Product.setSupplier(supplierService.getSupplier(supplierId));
		Product.setId(ProductId);
		productService.updateProduct(Product);
		return "redirect:/orders/";
	}
	
	@RequestMapping(value = "/{ProductId}/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteProduct(@PathVariable("ProductId") long ProductId) {
		
		productService.deleteProduct(ProductId);
		return "redirect:/orders";
	}

}