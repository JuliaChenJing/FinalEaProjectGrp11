package com.grp11.suppliers;

import org.springframework.data.repository.CrudRepository;

public interface ISupplier extends CrudRepository<SupplierDomain, Long> {
	
}
