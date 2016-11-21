package com.grp11.category;

import java.util.List;

public interface ICategoryDao {
	public void createCategory(CategoryDomain o);
	public CategoryDomain updateCategory(CategoryDomain o);
	public CategoryDomain getCategory(Long ordNum);
	public List<CategoryDomain> getAllCategory();
	public void deleteCategory(Long ordNum);
}
