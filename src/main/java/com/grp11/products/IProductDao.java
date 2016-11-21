package com.grp11.products;
import java.util.List;

import org.springframework.data.repository.query.Param;


public interface IProductDao {
	public void createProduct(ProductDomain o);
	public ProductDomain updateProduct(ProductDomain o);
	public ProductDomain getProduct(Long ordNum);
	public List<ProductDomain> getAllProduct();
	public void deleteProduct(Long ordNum);
	public List<ProductDomain> getAllProductForSupplier(long supplierId);
	public List<ProductDomain> getAllProductForCategory(long categoryId);
}
