package com.grp11.suppliers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SupplierSrvc implements ISupplierService {
	@Autowired
	private ISupplierDao StoreDao;
	@Override
	public void createStore(SupplierDomain o) {
		StoreDao.createStore(o);
	}
	@Override
	public SupplierDomain updateStore(SupplierDomain o) {
		return StoreDao.updateStore(o);
	}
	@Override
	public SupplierDomain getStore(Long ordNum) {
		return StoreDao.getStore(ordNum);
	}
	@Override
	public List<SupplierDomain> getAllStore() {
		return StoreDao.getAllStore();
	}
	@Override
	public void deleteStore(Long ordNum) {
		StoreDao.deleteStore(ordNum);
	}
}
