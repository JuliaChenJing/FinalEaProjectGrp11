package com.grp11.payment;

import java.util.Date;
import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.grp11.Domain.ConsumerDomain;
import com.grp11.Domain.UserDomain;
@Entity
public class PaymentDomain {
	@Id
	@GeneratedValue
	private long id;
	private String cardType;
	@Override
	public String toString() {
		return "PaymentDomain [id=" + id + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", CVV=" + CVV
				+ ", nameOnCard=" + nameOnCard + ", expiryDate=" + expiryDate + "]";
	}
	private String cardNumber;
	private String CVV;
	private String nameOnCard;
	
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public long getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="cust_id")
	public UserDomain consumer;
	public UserDomain getConsumer() {
		return consumer;
	}
	public void setConsumer(UserDomain consumer) {
		this.consumer = consumer;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CVV == null) ? 0 : CVV.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((consumer == null) ? 0 : consumer.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nameOnCard == null) ? 0 : nameOnCard.hashCode());
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
		PaymentDomain other = (PaymentDomain) obj;
		if (CVV == null) {
			if (other.CVV != null)
				return false;
		} else if (!CVV.equals(other.CVV))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (consumer == null) {
			if (other.consumer != null)
				return false;
		} else if (!consumer.equals(other.consumer))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (id != other.id)
			return false;
		if (nameOnCard == null) {
			if (other.nameOnCard != null)
				return false;
		} else if (!nameOnCard.equals(other.nameOnCard))
			return false;
		return true;
	}
	
}
