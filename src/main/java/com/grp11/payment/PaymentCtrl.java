package com.grp11.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.grp11.Consumer.IConsumerService;
import com.grp11.Domain.ConsumerDomain;
@Controller
@RequestMapping("/payments")
public class PaymentCtrl {
	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private IConsumerService consumerService;

	@RequestMapping(value = "/{UserId}/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addConsumer(PaymentDomain Payment, @PathVariable("UserId") long UserId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		Payment.setConsumer(c);
		paymentService.createPayment(Payment);
		return "redirect:/payments/" + UserId;
	}
	
	@RequestMapping(value = "/{UserId}/{PaymentId}", method = RequestMethod.POST)//Browser doesn't supprot put method
	@ResponseStatus(HttpStatus.OK)
	public String updateConsumer(PaymentDomain Payment, @PathVariable("UserId") long UserId, @PathVariable("PaymentId") long PaymentId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		Payment.setConsumer(c);
		Payment.setId(PaymentId);
		System.out.println(Payment.toString());
		paymentService.updatePayment(Payment);
		return "redirect:/payments/" + UserId;
	}
	
	@RequestMapping(value = "/{paymentId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteConsumer(@PathVariable("paymentId") long paymentId) {
		paymentService.deletePayment(paymentId);
		
	}
	
	@RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllPaymentsForSpecificUser(@PathVariable("UserId") long UserId, Model model) {
		if(paymentService.getAllPaymentForUser(UserId).size()==0) return "paymentForm";
		model.addAttribute("allPayments", paymentService.getAllPaymentForUser(UserId).get(0));
		return "paymentFormEdit";
	}

}