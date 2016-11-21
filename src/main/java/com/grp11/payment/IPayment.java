package com.grp11.payment;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IPayment extends CrudRepository<PaymentDomain, Long> {
	@Query("SELECT p FROM PaymentDomain p WHERE p.consumer.id = :consumerId")
	public List<PaymentDomain> getAllPaymentForUser(@Param("consumerId") long consumerId);
}
