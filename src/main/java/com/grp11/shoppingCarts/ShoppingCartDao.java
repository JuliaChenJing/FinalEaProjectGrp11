package com.grp11.shoppingCarts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartDao implements IShoppingCartDao {
	@Autowired
	private IShoppingCart ShoppingCart;
	@Override
	public void createShoppingCart(ShoppingCartDomain o) {
		System.out.println(ShoppingCart.save(o).getClass().getName());
		ShoppingCart.save(o);
	}
	@Override
	public ShoppingCartDomain updateShoppingCart(ShoppingCartDomain o) {
		System.out.println(ShoppingCart.save(o).getClass().getName());
		return ShoppingCart.save(o);
	}
	@Override
	public ShoppingCartDomain getShoppingCart(Long ordNum) {
		return ShoppingCart.findOne(ordNum);
	}
	@Override
	public List<ShoppingCartDomain> getAllShoppingCart() {
		return StreamSupport.stream(ShoppingCart.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteShoppingCart(Long ordNum) {
		ShoppingCart.delete(ordNum);
	}
}
