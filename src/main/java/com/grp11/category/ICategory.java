package com.grp11.category;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICategory extends CrudRepository<CategoryDomain, Long> {
}
