package com.grp11.Order;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class OrderDomain {
	@Id
	@GeneratedValue
	private long id;
	private int quantity;
	private int price;
	public long getId() {
		return id;
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
