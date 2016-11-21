package com.grp11.suppliers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SupplierDao implements ISupplierDao {
	@Autowired
	private ISupplier Supplier;
	@Override
	public void createSupplier(SupplierDomain o) {
		System.out.println("creating supplier");
		Supplier.save(o);
	}
	@Override
	public SupplierDomain updateSupplier(SupplierDomain o) {
		System.out.println(Supplier.save(o).getClass().getName());
		return Supplier.save(o);
	}
	@Override
	public SupplierDomain getSupplier(Long ordNum) {
		return Supplier.findOne(ordNum);
	}
	@Override
	public List<SupplierDomain> getAllSupplier() {
		return StreamSupport.stream(Supplier.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteSupplier(Long ordNum) {
		Supplier.delete(ordNum);
	}
}