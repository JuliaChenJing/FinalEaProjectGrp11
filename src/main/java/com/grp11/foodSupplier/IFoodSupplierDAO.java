package com.grp11.foodSupplier;

import org.springframework.data.repository.CrudRepository;

import com.grp11.Domain.SuppliersDomain;

public interface IFoodSupplierDAO extends CrudRepository<SuppliersDomain, Long>{

}
