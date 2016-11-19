package com.grp11.stores;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
import com.grp11.customers.*;
/**
 * @author suman
 * Description: StoreService. Call crud operations from here. Add other related methods. Remember SOC and DRY
 */
public class StoreService implements IStoreService {
	private IStoreDao StoreDao;
	public IStoreDao getStoreDao() {
		return StoreDao;
	}
	public void setStoreDao(IStoreDao StoreDao) {
		this.StoreDao = StoreDao;
	}
	@Override
	@Transactional
	public void saveStore(Store e) {
		StoreDao.saveStore(e);
	}
	@Override
	@Transactional
	public void updateStore(Store  e) {
		StoreDao.updateStore(e);
	}
	@Override
	@Transactional
	public Store loadStore(int eNo) {
		return StoreDao.loadStore(eNo);
	}
	@Override
	public Collection<Store> getStore() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return StoreDao.getStore();
	}
}