package com.grp11.products;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

public class ProductDao implements IProductDao {
	@Autowired
	private IProduct Product;
	@Override
	public void createProduct(ProductDomain o) {
		System.out.println(Product.save(o).getClass().getName());
		Product.save(o);
	}
	@Override
	public ProductDomain updateProduct(ProductDomain o) {
		System.out.println(Product.save(o).getClass().getName());
		return Product.save(o);
	}
	@Override
	public ProductDomain getProduct(Long ordNum) {
		return Product.findOne(ordNum);
	}
	@Override
	public List<ProductDomain> getAllProduct() {
		return StreamSupport.stream(Product.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteProduct(Long ordNum) {
		Product.delete(ordNum);
	}
	@Override
	public List<ProductDomain> getAllProductForSupplier(long supplierId){
		return Product.getAllProductForSupplier(supplierId);
	}
}