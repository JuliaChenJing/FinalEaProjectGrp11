package com.grp11.stores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class StoreSrvc implements IStoreService {
	@Autowired
	private IStoreDao StoreDao;
	@Override
	public void createStore(StoreDomain o) {
		StoreDao.createStore(o);
	}
	@Override
	public StoreDomain updateStore(StoreDomain o) {
		return StoreDao.updateStore(o);
	}
	@Override
	public StoreDomain getStore(Long ordNum) {
		return StoreDao.getStore(ordNum);
	}
	@Override
	public List<StoreDomain> getAllStore() {
		return StoreDao.getAllStore();
	}
	@Override
	public void deleteStore(Long ordNum) {
		StoreDao.deleteStore(ordNum);
	}
}
