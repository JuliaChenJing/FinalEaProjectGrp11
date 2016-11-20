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

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String addPaymentPage() {
		return "paymentForm";
	}
	@RequestMapping(value = "/{UserId}/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addConsumer(PaymentDomain Payment, @PathVariable("UserId") long UserId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		Payment.setConsumer(c);
		paymentService.createPayment(Payment);
		return "redirect:/payments";
	}
	
	@RequestMapping(value = "/{UserId}/{PaymentId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String updateConsumer(@RequestBody PaymentDomain Payment, @PathVariable("UserId") long UserId) {
		ConsumerDomain c = consumerService.getUser(UserId);
		Payment.setConsumer(c);
		paymentService.updatePayment(Payment);
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteConsumer(@RequestBody PaymentDomain Payment) {
		paymentService.deletePayment(Payment.getId());
		return "redirect:/home2";
	}
	
	@RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllPaymentsForSpecificUser(@PathVariable("UserId") long UserId, Model model) {
		model.addAttribute("allPayments", paymentService.getAllPaymentForUser(UserId));
		return "home2";
	}

}