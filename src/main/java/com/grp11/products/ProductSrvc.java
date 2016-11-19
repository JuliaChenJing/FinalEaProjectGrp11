package com.grp11.products;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductSrvc implements IProductService {
	@Autowired
	private IProductDao ProductDao;
	@Override
	public void createProduct(ProductDomain o) {
		ProductDao.createProduct(o);
	}
	@Override
	public ProductDomain updateProduct(ProductDomain o) {
		return ProductDao.updateProduct(o);
	}
	@Override
	public ProductDomain getProduct(Long ordNum) {
		return ProductDao.getProduct(ordNum);
	}
	@Override
	public List<ProductDomain> getAllProduct() {
		return ProductDao.getAllProduct();
	}
	@Override
	public void deleteProduct(Long ordNum) {
		ProductDao.deleteProduct(ordNum);
	}
}
