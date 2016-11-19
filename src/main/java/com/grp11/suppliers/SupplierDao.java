package com.grp11.suppliers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

public class SupplierDao implements ISupplierDao {
	@Autowired
	private ISupplier Store;
	@Override
	public void createStore(SupplierDomain o) {
		System.out.println(Store.save(o).getClass().getName());
		Store.save(o);
	}
	@Override
	public SupplierDomain updateStore(SupplierDomain o) {
		System.out.println(Store.save(o).getClass().getName());
		return Store.save(o);
	}
	@Override
	public SupplierDomain getStore(Long ordNum) {
		return Store.findOne(ordNum);
	}
	@Override
	public List<SupplierDomain> getAllStore() {
		return StreamSupport.stream(Store.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteStore(Long ordNum) {
		Store.delete(ordNum);
	}
}