package com.grp11.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderSrvc implements IOrderService {
	@Autowired
	private IOrderDao OrderDao;
	@Override
	public void createOrder(OrderDomain o) {
		OrderDao.createOrder(o);
	}
	@Override
	public OrderDomain updateOrder(OrderDomain o) {
		return OrderDao.updateOrder(o);
	}
	@Override
	public OrderDomain getOrder(Long ordNum) {
		return OrderDao.getOrder(ordNum);
	}
	@Override
	public List<OrderDomain> getAllOrder() {
		return OrderDao.getAllOrder();
	}
	@Override
	public void deleteOrder(Long ordNum) {
		OrderDao.deleteOrder(ordNum);
	}
}
