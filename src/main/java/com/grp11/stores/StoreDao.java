package com.grp11.stores;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
/**
 * @author suman Description: StoreDao. Only crud operations to be added here.
 *         {May be validations as well}
 */
public class StoreDao implements IStoreDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	@Transactional
	public void saveStore(Store e) {
		sf.getCurrentSession().persist(e);
	}

	@Override
	@Transactional
	public void updateStore(Store e) {
		sf.getCurrentSession().saveOrUpdate(e);
	}

	@Override
	@Transactional
	public Store loadStore(int eNo) {
		return (Store) sf.getCurrentSession().get(Store.class, eNo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Store> getStore() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly
		// load!
		// TODO: check why getCurrentSession throws error here
		return sf.openSession().createQuery("select distinct e from StoreDomain e").list();
	}

}