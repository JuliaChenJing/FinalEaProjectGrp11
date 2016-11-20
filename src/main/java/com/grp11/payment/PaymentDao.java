package com.grp11.payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PaymentDao implements IPaymentDao {
	@Autowired
	private IPayment Payment;
	@Override
	public void createPayment(PaymentDomain o) {
		System.out.println(Payment.save(o).getClass().getName());
		Payment.save(o);
	}
	@Override
	public PaymentDomain updatePayment(PaymentDomain o) {
		System.out.println(Payment.save(o).getClass().getName());
		return Payment.save(o);
	}
	@Override
	public PaymentDomain getPayment(Long ordNum) {
		return Payment.findOne(ordNum);
	}
	@Override
	public List<PaymentDomain> getAllPayment() {
		return StreamSupport.stream(Payment.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deletePayment(Long ordNum) {
		Payment.delete(ordNum);
	}
	@Override 
	public List<PaymentDomain> getAllPaymentForUser(long consumerId) {
		return Payment.getAllPaymentForUser(consumerId);
	}
}
