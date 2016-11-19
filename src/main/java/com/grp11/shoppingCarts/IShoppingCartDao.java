package com.grp11.shoppingCarts;

import java.util.Collection;

import com.grp11.address.*;
public interface IShoppingCartDao {
		public void saveShoppingCart(ShoppingCart e);
		public void updateShoppingCart(ShoppingCart e);
		public ShoppingCart loadShoppingCart(int e);
		public Collection<ShoppingCart> getShoppingCart();
}