package com.grp11.shoppingCarts;


import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ShoppingCartCtrl {
	@RequestMapping(value = "/ShoppingCarts", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllExamples() {
		return "home2";
	}
}