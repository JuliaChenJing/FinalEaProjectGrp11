package com.grp11.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.grp11.logfile.Logger;



@Aspect

public class TraceAdvice {
	@Autowired
	private Logger logger;

	@After("execution(* com.grp11.Consumer.ConsumerCtrl.deleteConsumer(..))")
	public void traceAfterMethod(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().getName();
		System.out.println("**************************************");
		logger.log(method + " action has been performed for current order.");
	}

}
