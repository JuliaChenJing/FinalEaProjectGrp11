package com.grp11.foodSupplier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp11.Domain.SuppliersDomain;

@Service
@Transactional
public class FoodSupplierServiceImpl implements IFoodSupplierService {

	@Autowired
	private IFoodSupplierDAO foodsupplierDAO;
	@Override
	public void addSupplier(SuppliersDomain supplier) {
		foodsupplierDAO.save(supplier);
		
	}

	@Override
	public List<SuppliersDomain> getAllSuppliers() {
		return (List<SuppliersDomain>) foodsupplierDAO.findAll() ;
	}

}
