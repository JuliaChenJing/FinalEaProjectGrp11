package com.grp11.payment;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grp11.Consumer.IConsumerService;

import com.grp11.Domain.UserDomain;
import com.grp11.Order.IOrderService;
import com.grp11.Order.OrderDomain;
import com.grp11.util.ResponseObj;
@Controller
@RequestMapping("/payments")
public class PaymentCtrl {
	private static final String ServiceURL = "http://localhost:3001/card_validation/isvalid?cardNumber=";
	private static final String PaymentServiceURL = "http://localhost:3001/card_validation/hasbalance?cardNumber=";
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IConsumerService userService;
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private IConsumerService consumerService;
	private boolean checkValidation(PaymentDomain payment, String url) {
		String validationURL = url + payment.getCardNumber();
		ResponseObj r = restTemplate.getForObject(validationURL, ResponseObj.class);
		System.out.println(r.toString());
		return r.isSuccess() && r.isValid();
	}
	@RequestMapping(value = "/{UserId}/new", method = RequestMethod.POST)
	public String addPayment(PaymentDomain payment, @PathVariable("UserId") long UserId) {
		if(checkValidation(payment, ServiceURL)) {
			UserDomain c = consumerService.getUser(UserId);
			payment.setConsumer(c);
			System.out.println(c.getId());
			paymentService.createPayment(payment);
			return "redirect:/payments/" + UserId;
		} else {
			return "redirect:/products/";
		}
	}
	
	@RequestMapping(value = "/{UserId}/{PaymentId}", method = RequestMethod.POST)//Browser doesn't supprot put method
	public String updatePayment(PaymentDomain payment, @PathVariable("UserId") long UserId, @PathVariable("PaymentId") long PaymentId) {
		if(checkValidation(payment, ServiceURL)) {
			UserDomain c = consumerService.getUser(UserId);
			payment.setConsumer(c);
			payment.setId(PaymentId);
			paymentService.updatePayment(payment);
			return "redirect:/payments/"+UserId;
		} else return "redirect:/products";
	}
	
	@RequestMapping(value = "/{paymentId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePayment(@PathVariable("paymentId") long paymentId) {
		paymentService.deletePayment(paymentId);
		
	}
	
	@RequestMapping(value = {"/{UserId}", "/{UserId}/{paymentId}"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllPaymentsForSpecificUser(@PathVariable("UserId") long UserId, Model model) {
		if(paymentService.getAllPaymentForUser(UserId).size()==0) return "paymentForm";
		model.addAttribute("allPayments", paymentService.getAllPaymentForUser(UserId).get(0));
		return "paymentFormEdit";
	}
	
	@RequestMapping(value = {"/{UserId}/makepayment"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String makePayments(@PathVariable("UserId") long UserId, Model model) {
		if(paymentService.getAllPaymentForUser(UserId).size()==0) return "paymentForm";
		List<OrderDomain> listOrder = orderService.getAllOrderForUser(UserId);
		model.addAttribute("allOrders", listOrder);
		int total = 0;
		for(OrderDomain o : listOrder) {
			total += o.getPrice();
		}
		model.addAttribute("total", total);
		model.addAttribute("user", userService.getUser(UserId));
		model.addAttribute("allPayments", paymentService.getAllPaymentForUser(UserId).get(0));
		return "payNow";
	}
	
	@RequestMapping(value = "/{UserId}/pay", method = RequestMethod.POST)//Browser doesn't supprot put method
	public void payNow(@PathVariable("UserId") long UserId, HttpServletResponse response) {
		System.out.println("hereeeeee");
		PaymentDomain payment = paymentService.getAllPaymentForUser(UserId).get(0);
		System.out.println(payment.getCardNumber());
		if(checkValidation(payment, PaymentServiceURL)) {
			System.out.println("successful");
			List<OrderDomain> listOrder = orderService.getAllOrderForUser(UserId);
			for(OrderDomain o : listOrder) {
				o.setPaid(true);
				orderService.updateOrder(o);
			}
			
		} else {
			System.out.println("failure");
			response.setStatus(403);
		}
	}
}