package com.grp11.products;


import org.springframework.data.repository.CrudRepository;

public interface IProduct extends CrudRepository<ProductDomain, Long> {

}
