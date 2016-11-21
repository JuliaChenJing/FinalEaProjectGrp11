package com.grp11.category;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CategoryDao implements ICategoryDao {
	@Autowired
	private ICategory Category;
	@Override
	public void createCategory(CategoryDomain o) {
		System.out.println(Category.save(o).getClass().getName());
		Category.save(o);
	}
	@Override
	public CategoryDomain updateCategory(CategoryDomain o) {
		System.out.println(Category.save(o).getClass().getName());
		return Category.save(o);
	}
	@Override
	public CategoryDomain getCategory(Long ordNum) {
		return Category.findOne(ordNum);
	}
	@Override
	public List<CategoryDomain> getAllCategory() {
		return StreamSupport.stream(Category.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteCategory(Long ordNum) {
		Category.delete(ordNum);
	}

}
