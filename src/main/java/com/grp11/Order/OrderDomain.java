package com.grp11.Order;

import java.util.Date;

import javax.persistence.*;

import com.grp11.Domain.ConsumerDomain;

import com.grp11.Domain.UserDomain;
import com.grp11.products.ProductDomain;




@Entity
@Table(name="Orders")
public class OrderDomain {
	@Id
	@GeneratedValue
	private long id;
	private int quantity;
	private int price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	private boolean isPaid;
	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private UserDomain consumer;
	public UserDomain getConsumer() {
		return consumer;
	}

	public void setConsumer(UserDomain consumer) {
		this.consumer = consumer;
	}

	//	TODO: unlock them with relationship when other domains are ready
	@ManyToOne
	private ProductDomain product;
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ProductDomain getProduct() {
		return product;
	}

	public void setProduct(ProductDomain product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((consumer == null) ? 0 : consumer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + price;
		result = prime * result + quantity;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (consumer == null) {
			if (other.consumer != null)
				return false;
		} else if (!consumer.equals(other.consumer))
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
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
