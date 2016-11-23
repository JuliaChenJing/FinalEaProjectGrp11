package com.grp11;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.grp11.Order.IOrder;
import com.grp11.Order.OrderDomain;
@EnableAutoConfiguration
@Configuration
@EnableAspectJAutoProxy
@SpringBootApplication
@ComponentScan({"com.grp11"})
public class FinalEaProjectGrp11Application {
//	@Autowired
//	private IOrder repository;
	public static void main(String[] args) {
		
		SpringApplication.run(FinalEaProjectGrp11Application.class, args);
	}
	//	TODO: create the first admin from here check if already exists first
	/*@PostConstruct
	public void init() {
		OrderDomain o = new OrderDomain();
		o.setPrice(1);
		o.setQuantity(2);
		repository.save(o);
	}*/
}
