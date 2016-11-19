package com.grp11.products;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
import com.grp11.customers.*;


/**
 * @author suman
 * Description: ProductService. Call crud operations from here. Add other related methods. Remember SOC and DRY
 */
public class ProductService implements IProductService {
	private IProductDao ProductDao;
	public IProductDao getProductDao() {
		return ProductDao;
	}
	public void setProductDao(IProductDao ProductDao) {
		this.ProductDao = ProductDao;
	}
	@Override
	@Transactional
	public void saveProduct(Product e) {
		ProductDao.saveProduct(e);
	}
	@Override
	@Transactional
	public void updateProduct(Product e) {
		ProductDao.updateProduct(e);
	}
	@Override
	@Transactional
	public Product loadProduct(int eNo) {
		return ProductDao.loadProduct(eNo);
	}
	@Override
	public Collection<Product> getProduct() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return ProductDao.getProduct();
	}
}