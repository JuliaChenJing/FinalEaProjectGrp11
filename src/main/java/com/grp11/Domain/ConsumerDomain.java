package com.grp11.Domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.grp11.Order.OrderDomain;

@Entity
@DiscriminatorValue("ROLE_CONSUMER")
public class ConsumerDomain extends UserDomain{
	
	
	private List<OrderDomain> orders;

	public List<OrderDomain> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDomain> orders) {
		this.orders = orders;
	}
	
	
	
}
