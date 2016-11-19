package com.grp11.Order;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class OrderCtrl {
	@Autowired
	private IOrderService orderService;
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllExamples() {
		return "home2";
	}
	@RequestMapping(value = "/orders/{UserId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllUserOrders(@PathVariable("UserId") long UserId) {
		orderService.getAllOrderForUser(UserId).forEach(System.out::println);
		return "home2";
	}
}