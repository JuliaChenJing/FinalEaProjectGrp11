package com.grp11.address;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
/**
 * @author suman
 * Description: AddressDao. Only crud operations to be added here. {May be validations as well}
 */
public class AddressDao implements IAddressDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	@Transactional
	public void saveAddress(Address e) {
		sf.getCurrentSession().persist(e);
	}
	@Override
	@Transactional
	public void updateAddress(Address e) {
		sf.getCurrentSession().saveOrUpdate(e);
	}
	@Override
	@Transactional
	public Address loadAddress(int eNo) {
		return (Address) sf.getCurrentSession().get(Address.class, eNo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Address> getAddress() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		//	TODO: check why getCurrentSession throws error here
		return sf.openSession().createQuery("select distinct e from AddressDomain e").list();
	}

}