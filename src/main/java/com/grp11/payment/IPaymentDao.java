package com.grp11.payment;

import java.util.List;

public interface IPaymentDao {
	public void createPayment(PaymentDomain o);
	public PaymentDomain updatePayment(PaymentDomain o);
	public PaymentDomain getPayment(Long ordNum);
	public List<PaymentDomain> getAllPayment();
	public void deletePayment(Long ordNum);
	public List<PaymentDomain> getAllPaymentForUser(long consumerId);
}
