package com.grp11.category;

import java.util.List;

import javax.persistence.*;

import com.grp11.products.ProductDomain;




@Entity
@Table(name="Categories")
public class CategoryDomain {
	@Override
	public String toString() {
		return "CategoryDomain [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDomain other = (CategoryDomain) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy="category")
	private List<ProductDomain> products;
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
