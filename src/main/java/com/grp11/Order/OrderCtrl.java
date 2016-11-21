/*package com.grp11.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.Consumer.IConsumerService;
import com.grp11.Domain.ConsumerDomain;
import com.grp11.Domain.UserDomain;
@Controller
@RequestMapping("/orders")
public class OrderCtrl {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IConsumerService consumerService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllOrdersFromAllUser(Model model) {
		model.addAttribute("allOrders", orderService.getAllOrder());
		return "home2";
	}

	@RequestMapping(value = "/{UserId}/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addConsumer(@RequestBody OrderDomain order, @PathVariable("UserId") long UserId) {
		UserDomain c = consumerService.getUser(UserId);
		order.setConsumer(c);
		orderService.createOrder(order);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{UserId}/{OrderId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String updateConsumer(@RequestBody OrderDomain order, @PathVariable("UserId") long UserId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		order.setConsumer(c);
		orderService.updateOrder(order);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteConsumer(@RequestBody OrderDomain order) {
		orderService.deleteOrder(order.getId());
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllOrdersForSpecificUser(@PathVariable("UserId") long UserId, Model model) {
		model.addAttribute("allOrders", orderService.getAllOrderForUser(UserId));
		return "home2";
	}

}*/