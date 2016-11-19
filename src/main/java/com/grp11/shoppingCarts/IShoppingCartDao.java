package com.grp11.shoppingCarts;

import java.util.List;


public interface IShoppingCartDao {
	public void createShopping(ShoppingCartDomain o);
	public ShoppingCartDomain updateShopping(ShoppingCartDomain o);
	public ShoppingCartDomain getShopping(Long ordNum);
	public List<ShoppingCartDomain> getAllShopping();
	public void deleteShoppingCart(Long ordNum);
}
