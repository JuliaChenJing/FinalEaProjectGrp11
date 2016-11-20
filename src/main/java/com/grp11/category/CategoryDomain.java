package com.grp11.category;

import java.util.Date;

import javax.persistence.*;

import com.grp11.Domain.ConsumerDomain;




@Entity
@Table(name="Categories")
public class CategoryDomain {
	@Id
	@GeneratedValue
	private long id;
	private String name;
//	private List<Products> products;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
