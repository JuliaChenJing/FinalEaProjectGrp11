package com.grp11.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentSrvc implements IPaymentService {
	@Autowired
	private IPaymentDao PaymentDao;
	@Override
	public void createPayment(PaymentDomain o) {
		PaymentDao.createPayment(o);
	}
	@Override
	public PaymentDomain updatePayment(PaymentDomain o) {
		return PaymentDao.updatePayment(o);
	}
	@Override
	public PaymentDomain getPayment(Long ordNum) {
		return PaymentDao.getPayment(ordNum);
	}
	@Override
	public List<PaymentDomain> getAllPayment() {
		return PaymentDao.getAllPayment();
	}
	@Override
	public void deletePayment(Long ordNum) {
		PaymentDao.deletePayment(ordNum);
	}
	@Override
	public List<PaymentDomain> getAllPaymentForUser(long consumerId){
		return PaymentDao.getAllPaymentForUser(consumerId);
	}
}
