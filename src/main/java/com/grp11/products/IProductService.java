package com.grp11.products;

import java.util.Collection;

import com.grp11.address.*;

public interface IProductService {
	public void saveProduct(Product e);
	public void updateProduct(Product e);
	public Product loadProduct(int e);
	public Collection<Product> getProduct();
}