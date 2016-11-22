package com.grp11.foodSupplier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.grp11.Domain.SuppliersDomain;


public interface IFoodSupplierService {
	
	public void addSupplier(SuppliersDomain supplier);
	public List<SuppliersDomain> getAllSuppliers();
	
}
