package com.grp11.products;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
/**
 * @author suman
 * Description: ProductDao. Only crud operations to be added here. {May be validations as well}
 */
public class ProductDao implements IProductDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	@Transactional
	public void saveProduct(Product e) {
		sf.getCurrentSession().persist(e);
	}
	@Override
	@Transactional
	public void updateProduct(Product e) {
		sf.getCurrentSession().saveOrUpdate(e);
	}
	@Override
	@Transactional
	public Product loadProduct(int eNo) {
		return (Product) sf.getCurrentSession().get(Product.class, eNo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Product> getProduct() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		//	TODO: check why getCurrentSession throws error here
		return sf.openSession().createQuery("select distinct e from ProductDomain e").list();
	}

}