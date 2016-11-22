package com.grp11.category;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryCtrl {
	@Autowired
	private ICategoryService CategoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllCategorys(Model model) {
		model.addAttribute("allCategorys", CategoryService.getAllCategory());
		return "home2";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String addCategory() {
		return "addCategory";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute CategoryDomain Category) {
		CategoryService.createCategory(Category);
		return "redirect:/category/list/all";
	}
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getProducts(Model model) throws UnsupportedEncodingException {
		model.addAttribute("allCategory", CategoryService.getAllCategory());
		return "listCategories";
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getCategory(Model model, @PathVariable("categoryId") long categoryId) {
		model.addAttribute("category", CategoryService.getCategory(categoryId));
		return "updateCategory";
	}
	
	@RequestMapping(value = "/{categoryId}/update", method = RequestMethod.POST)
	public String updateCategory(CategoryDomain Category, @PathVariable("categoryId") long categoryId) {
		Category.setId(categoryId);
		CategoryService.updateCategory(Category);
		return "redirect:/category/list/all";
	}
	
	@RequestMapping(value = "/{categoryId}/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String deleteCategory(@PathVariable("categoryId") long categoryId) {
		CategoryService.deleteCategory(categoryId);
		return "true";
	}
	

}