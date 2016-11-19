package com.grp11.suppliers;

import java.util.List;


public interface ISupplierService {
	public void createStore(SupplierDomain o);
	public SupplierDomain updateStore(SupplierDomain o);
	public SupplierDomain getStore(Long ordNum);
	public List<SupplierDomain> getAllStore();
	public void deleteStore(Long ordNum);
}
