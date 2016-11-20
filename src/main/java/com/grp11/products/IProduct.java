package com.grp11.products;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IProduct extends CrudRepository<ProductDomain, Long> {
	@Query("SELECT p FROM ProductDomain p WHERE p.supplier.id = :supplierId")
	public List<ProductDomain> getAllProductForSupplier(@Param("supplierId") long supplierId);
}
