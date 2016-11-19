package com.grp11.products;

import java.util.Collection;

public interface IProductDao {
		public void saveProduct(Product e);
		public void updateProduct(Product e);
		public Product loadProduct(int e);
		public Collection<Product> getProduct();
}