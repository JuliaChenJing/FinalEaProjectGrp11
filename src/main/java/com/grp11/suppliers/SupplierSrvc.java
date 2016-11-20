package com.grp11.suppliers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SupplierSrvc implements ISupplierService {
	@Autowired
	private ISupplierDao SupplierDao;
	@Override
	public void createSupplier(SupplierDomain o) {
		System.out.println("inside supplier service");
		SupplierDao.createSupplier(o);
	}
	@Override
	public SupplierDomain updateSupplier(SupplierDomain o) {
		return SupplierDao.updateSupplier(o);
	}
	@Override
	public SupplierDomain getSupplier(Long ordNum) {
		return SupplierDao.getSupplier(ordNum);
	}
	@Override
	public List<SupplierDomain> getAllSupplier() {
		return SupplierDao.getAllSupplier();
	}
	@Override
	public void deleteSupplier(Long ordNum) {
		SupplierDao.deleteSupplier(ordNum);
	}
}
