package com.grp11.suppliers;

import java.util.List;


public interface ISupplierService {
	public void createSupplier(SupplierDomain o);
	public SupplierDomain updateSupplier(SupplierDomain o);
	public SupplierDomain getSupplier(Long ordNum);
	public List<SupplierDomain> getAllSupplier();
	public void deleteSupplier(Long ordNum);
}
