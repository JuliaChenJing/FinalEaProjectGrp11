package com.grp11.customers;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
/**
 * @author suman
 * Description: CustomerDao. Only crud operations to be added here. {May be validations as well}
 */
public class CustomerDao implements ICustomerDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	@Transactional
	public void saveCustomer(Customer e) {
		sf.getCurrentSession().persist(e);
	}
	@Override
	@Transactional
	public void updateCustomer(Customer e) {
		sf.getCurrentSession().saveOrUpdate(e);
	}
	@Override
	@Transactional
	public Customer loadCustomer(int eNo) {
		return (Customer) sf.getCurrentSession().get(Customer.class, eNo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Customer> getCustomer() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		//	TODO: check why getCurrentSession throws error here
		return sf.openSession().createQuery("select distinct e from CustomerDomain e").list();
	}
}

