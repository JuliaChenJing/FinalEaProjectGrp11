package com.grp11.shoppingCarts;


import org.springframework.data.repository.CrudRepository;

public interface IShoppingCart extends CrudRepository<ShoppingCartDomain, Long> {

}
