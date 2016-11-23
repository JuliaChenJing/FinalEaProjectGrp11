package com.grp11.payment;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;

import com.grp11.util.IEmail;

//import com.grp11.util.Email;
//import com.grp11.util.ResponseObj;

@Aspect
@Component
public class AspectPayment {
//	private static final String ServiceURL = "http://localhost:3001/card_validation/isvalid?cardNumber=";
//	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private IEmail e;

	@After("execution(* com.grp11.payment.PaymentCtrl.*Payment(..)) and args(Payment, ..)")
	public void sendEmail(JoinPoint jp, PaymentDomain Payment) throws Throwable {
//		e.send(Payment.getConsumer().getEmail());
		e.send("lamasuman00114@gmail.com");
		System.out.println("Let us imagine we are sending email here");
	}
	@After("execution(* com.grp11.payment.PaymentCtrl.payNow(..)) and args(UserId, ..)")
	public void updateOrders(JoinPoint jp, long UserId) throws Throwable {
		
		System.out.println("am I in?");
	}
}
