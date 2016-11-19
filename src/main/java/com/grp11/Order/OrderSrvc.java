package com.grp11.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class OrderSrvc implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Override
	public void createOrder(OrderDomain o) {
		orderDao.createOrder(o);
	}
	@Override
	public OrderDomain updateOrder(OrderDomain o) {
		return orderDao.updateOrder(o);
	}
	@Override
	public OrderDomain getOrder(Long ordNum) {
		return orderDao.getOrder(ordNum);
	}
	@Override
	public List<OrderDomain> getAllOrder() {
		return orderDao.getAllOrder();
	}
	@Override
	public void deleteOrder(Long ordNum) {
		orderDao.deleteOrder(ordNum);
	}
}
