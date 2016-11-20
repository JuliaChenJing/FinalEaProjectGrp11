package com.grp11.products;
import java.util.List;



public interface IProductService {
	public void createProduct(ProductDomain o);
	public ProductDomain updateProduct(ProductDomain o);
	public ProductDomain getProduct(Long ordNum);
	public List<ProductDomain> getAllProduct();
	public void deleteProduct(Long ordNum);
	public List<ProductDomain> getAllProductForSupplier(long supplierId);
}

