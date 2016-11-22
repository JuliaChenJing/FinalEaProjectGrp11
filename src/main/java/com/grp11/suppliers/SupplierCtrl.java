package com.grp11.suppliers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
	public String addSupplier(SupplierDomain Supplier, BindingResult bindingResult, @RequestParam MultipartFile logo) throws IOException {
		if (logo != null) {
			Supplier.setLogo(logo.getBytes());
        }
		System.out.println("inside supplier add");
		SupplierService.createSupplier(Supplier);
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "/{supplierId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getSupplier(Model model, @PathVariable("supplierId") long supplierId) {
		model.addAttribute("supplier", SupplierService.getSupplier(supplierId));
		return "updateSupplier";
	}
	
	@RequestMapping(value = "/{supplierId}/update", method = RequestMethod.POST)
	public String updateSupplier(SupplierDomain Supplier, @PathVariable("supplierId") long supplierId, @RequestParam MultipartFile logo) throws IOException {
		if (logo != null) {
			Supplier.setLogo(logo.getBytes());
        }
		Supplier.setId(supplierId);
		SupplierService.updateSupplier(Supplier);
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "/image/{supplierId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getImageForProduct(Model model, @PathVariable("supplierId") long supplierId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException {
		System.out.println("getting image");
		SupplierDomain item = SupplierService.getSupplier(supplierId);
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    ServletOutputStream out = response.getOutputStream();
	    out.write(item.getLogo());
	    out.close();
	}
	
	@RequestMapping(value = "/{supplierId}/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String deleteSupplier(@PathVariable("supplierId") long supplierId) {
		SupplierService.deleteSupplier(supplierId);
		return "true";
	}

}