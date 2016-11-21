package com.grp11.payment;

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
import com.grp11.Domain.ConsumerDomain;
import com.grp11.Domain.UserDomain;
import com.grp11.util.ResponseObj;
@Controller
@RequestMapping("/payments")
public class PaymentCtrl {
	private static final String ServiceURL = "http://localhost:3001/card_validation/isvalid?cardNumber=";
	@Autowired
	private IPaymentService paymentService;

	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private IConsumerService consumerService;
	private boolean checkValidation(PaymentDomain payment) {
		String validationURL = ServiceURL + payment.getCardNumber();
		ResponseObj r = restTemplate.getForObject(validationURL, ResponseObj.class);
		System.out.println(r.toString());
		return r.isSuccess() && r.isValid();
	}
	@RequestMapping(value = "/{UserId}/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addPayment(PaymentDomain payment, @PathVariable("UserId") long UserId) {
		if(checkValidation(payment)) {
			UserDomain c = consumerService.getUser(UserId);
			payment.setConsumer(c);
			paymentService.createPayment(payment);
			return "redirect:/payments/" + UserId;
		} else {
			return "redirect:/orders/";
		}
	}
	
	@RequestMapping(value = "/{UserId}/{PaymentId}", method = RequestMethod.POST)//Browser doesn't supprot put method
	@ResponseStatus(HttpStatus.CREATED)
	public String updatePayment(PaymentDomain payment, @PathVariable("UserId") long UserId, @PathVariable("PaymentId") long PaymentId) {
		if(checkValidation(payment)) {
			UserDomain c = consumerService.getUser(UserId);
			payment.setConsumer(c);
			payment.setId(PaymentId);
			paymentService.updatePayment(payment);
			return "redirect:/payments/"+UserId;
		} else return "redirect:/orders";
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

}