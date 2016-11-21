/*package com.grp11.payment;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.grp11.util.ResponseObj;

@Aspect
@Component
public class AspectPayment {
	private static final String ServiceURL = "http://localhost:3001/card_validation/isvalid?cardNumber=";
	private RestTemplate restTemplate = new RestTemplate();
	@Around("execution(* com.grp11.payment.PaymentCtrl.*Payment(..)) and args(Payment, ..)")
	public String validateCard(ProceedingJoinPoint jp, PaymentDomain Payment) throws Throwable {
		
		String validationURL = ServiceURL + Payment.getCardNumber();
		System.out.println(validationURL);
		ResponseObj r = restTemplate.getForObject(validationURL, ResponseObj.class);
		System.out.println(r.toString());
		if(!r.isSuccess() || !r.isValid()) return "home2";
		Object a = jp.proceed();
		return a.toString();
		System.out.println("hee");
		System.out.println(r.isValid());
	}
}
*/