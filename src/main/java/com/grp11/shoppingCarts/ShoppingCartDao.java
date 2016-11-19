package com.grp11.shoppingCarts;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
/**
 * @author suman
 * Description: ShoppingCartDao. Only crud operations to be added here. {May be validations as well}
 */
public class ShoppingCartDao implements IShoppingCartDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	@Transactional
	public void saveShoppingCart(ShoppingCart e) {
		sf.getCurrentSession().persist(e);
	}
	@Override
	@Transactional
	public void updateShoppingCart(ShoppingCart e) {
		sf.getCurrentSession().saveOrUpdate(e);
	}
	@Override
	@Transactional
	public ShoppingCart loadShoppingCart(int eNo) {
		return (ShoppingCart) sf.getCurrentSession().get(ShoppingCart.class, eNo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ShoppingCart> getShoppingCart() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		//	TODO: check why getCurrentSession throws error here
		return sf.openSession().createQuery("select distinct e from ShoppingCartDomain e").list();
	}

}