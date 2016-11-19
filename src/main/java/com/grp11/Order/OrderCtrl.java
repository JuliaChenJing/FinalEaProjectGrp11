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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllOrdersFromAllUser(Model model) {
		model.addAttribute("allOrders", orderService.getAllOrder());
		return "home2";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addCustomer(@RequestBody OrderDomain order) {
		orderService.createOrder(order);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public String updateCustomer(@RequestBody OrderDomain order) {
		orderService.updateOrder(order);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public String deleteCustomer(@RequestBody OrderDomain order) {
		orderService.deleteOrder(order.getId());
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllOrdersForSpecificUser(@PathVariable("UserId") long UserId, Model model) {
		model.addAttribute("allOrders", orderService.getAllOrderForUser(UserId));
		return "home2";
	}

}