package com.grp11.Order;

import javax.persistence.*;

import com.grp11.User.UserDomain;

@Entity
@Table(name="Orders")
public class OrderDomain {
	@Id
	@GeneratedValue
	private long id;
	private int quantity;
	private int price;
//	TODO: unlock them with relationship when other domains are ready
//	@OneToMany
//	private User user;
//	@OneToMany
//	private Product product;
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + price;
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDomain other = (OrderDomain) obj;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
