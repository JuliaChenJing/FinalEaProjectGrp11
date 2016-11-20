package com.grp11.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategorySrvc implements ICategoryService {
	@Autowired
	private ICategoryDao CategoryDao;
	@Override
	public void createCategory(CategoryDomain o) {
		CategoryDao.createCategory(o);
	}
	@Override
	public CategoryDomain updateCategory(CategoryDomain o) {
		return CategoryDao.updateCategory(o);
	}
	@Override
	public CategoryDomain getCategory(Long ordNum) {
		return CategoryDao.getCategory(ordNum);
	}
	@Override
	public List<CategoryDomain> getAllCategory() {
		return CategoryDao.getAllCategory();
	}
	@Override
	public void deleteCategory(Long ordNum) {
		CategoryDao.deleteCategory(ordNum);
	}
}
