package com.grp11.shoppingCarts;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ShoppingCartSrvc implements IShoppingCartService {
	@Autowired
	private IShoppingCartDao ShoppingCartDao;
	@Override
	public void createShoppingCart(ShoppingCartDomain o) {
		ShoppingCartDao.createShoppingCart(o);
	}
	@Override
	public ShoppingCartDomain updateShoppingCart(ShoppingCartDomain o) {
		return ShoppingCartDao.updateShoppingCart(o);
	}
	@Override
	public ShoppingCartDomain getShoppingCart(Long ordNum) {
		return ShoppingCartDao.getShoppingCart(ordNum);
	}
	@Override
	public List<ShoppingCartDomain> getAllShoppingCart() {
		return ShoppingCartDao.getAllShoppingCart();
	}
	@Override
	public void deleteShoppingCart(Long ordNum) {
		ShoppingCartDao.deleteShoppingCart(ordNum);
	}
}
