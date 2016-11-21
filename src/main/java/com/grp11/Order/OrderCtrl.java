package com.grp11.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.Consumer.IConsumerService;
import com.grp11.Domain.ConsumerDomain;
import com.grp11.products.IProductService;
import com.grp11.products.ProductDomain;
@Controller
@RequestMapping("/orders")
public class OrderCtrl {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IConsumerService consumerService;
	@Autowired
	private IProductService productService;
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllOrdersFromAllUser(Model model) {
		model.addAttribute("allOrders", orderService.getAllOrder());
		return "home2";
	}
	
	@RequestMapping(value = {"/{UserId}/{productId}/new", "/{UserId}/{productId}/new/"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String startOrdering(Model model, @PathVariable("productId") long productId, @PathVariable("UserId") long UserId) {
		model.addAttribute("userId", UserId);
		model.addAttribute("product", productService.getProduct(productId));
		return "addOrder";
	}
	
	@RequestMapping(value = "/{UserId}/{ProductId}/new", method = RequestMethod.POST)
	public String addConsumer(OrderDomain order, @PathVariable("UserId") long UserId, @PathVariable("ProductId") long ProductId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		ProductDomain p = productService.getProduct(ProductId);
		System.out.println("some one is not here");
		order.setProduct(p);
		order.setConsumer(c);
		orderService.createOrder(order);
		return "redirect:/orders/";
	}
	
	@RequestMapping(value = "/{UserId}/{ProductId}/{OrderId}", method = RequestMethod.POST)
	public String updateConsumer(@RequestBody OrderDomain order, @PathVariable("UserId") long UserId, @PathVariable("UserId") long ProductId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		ProductDomain p = productService.getProduct(ProductId);
		order.setProduct(p);
		order.setConsumer(c);
		orderService.updateOrder(order);
		return "redirect:/orders/";
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

}