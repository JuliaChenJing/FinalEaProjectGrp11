package com.grp11.Order;

import org.springframework.data.repository.CrudRepository;

public interface IOrder extends CrudRepository<OrderDomain, Long> {

}
