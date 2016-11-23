package com.grp11.Consumer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class AdviceLog {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@After("execution(* com.grp11.Consumer.ConsumerCtrl.deleteConsumer(..))")
	public void DeleteMessageDisplay(JoinPoint joinPoint){
		System.out.println("===========The user is deleted==============");
		logger.info("Method delete has been called");
	}

}
