package com.grp11.Domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.grp11.Order.OrderDomain;

@Entity
@DiscriminatorValue("ROLE_CONSUMER")
public class ConsumerDomain extends UserDomain{
	
	@Transient	
	private List<OrderDomain> orders;

	public List<OrderDomain> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDomain> orders) {
		this.orders = orders;
	}
	
	
	
}
