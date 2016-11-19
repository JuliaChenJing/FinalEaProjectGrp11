package com.grp11.Order;

import java.util.List;

public interface IOrderService {
	public void createOrder(OrderDomain o);
	public OrderDomain updateOrder(OrderDomain o);
	public OrderDomain getOrder(Long ordNum);
	public List<OrderDomain> getAllOrder();
	public void deleteOrder(Long ordNum);
}
