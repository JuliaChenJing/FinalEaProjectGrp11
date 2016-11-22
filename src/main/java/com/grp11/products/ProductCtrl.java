package com.grp11.products;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
	public String getAllProducts(Model model) throws UnsupportedEncodingException {
		model.addAttribute("allProducts", productService.getAllProduct());
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("requestedCategory", 0);
		return "displayProducts";
	}
	
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getProducts(Model model) throws UnsupportedEncodingException {
		model.addAttribute("allProducts", productService.getAllProduct());
		return "listProducts";
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllProductsForCategory(Model model, @PathVariable("categoryId") long categoryId) {
		model.addAttribute("allProducts", productService.getAllProductForCategory(categoryId));
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("requestedCategory", categoryId);
		return "displayProducts";
	}
	
	@RequestMapping(value = "/image/{productId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getImageForProduct(Model model, @PathVariable("productId") long productId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException {
		System.out.println("getting image");
		ProductDomain item = productService.getProduct(productId);
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    ServletOutputStream out = response.getOutputStream();
	    out.write(item.getProductImage());
	    out.close();
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String addNewProduct(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("suppliers", supplierService.getAllSupplier());
		return "addProduct";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(ProductDomain Product, BindingResult result, Long supplierId, Long categoryId, @RequestParam MultipartFile productImage) throws IOException {
		if (productImage != null) {
			Product.setProductImage(productImage.getBytes());
        }
		Product.setCategory(categoryService.getCategory(categoryId));
		Product.setSupplier(supplierService.getSupplier(supplierId));
		productService.createProduct(Product);
		System.out.println(Product.getProductImage());
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