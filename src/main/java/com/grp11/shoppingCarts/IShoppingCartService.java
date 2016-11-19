package com.grp11.shoppingCarts;

import java.util.List;



public interface IShoppingCartService {
	public void createShoppingCart(ShoppingCartDomain o);
	public ShoppingCartDomain updateShoppingCart(ShoppingCartDomain o);
	public ShoppingCartDomain getShoppingCart(Long ordNum);
	public List<ShoppingCartDomain> getAllShoppingCart();
	public void deleteShoppingCart(Long ordNum);
}
