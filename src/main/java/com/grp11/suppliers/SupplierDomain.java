package com.grp11.suppliers;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
import com.grp11.products.*;

@Entity
public class SupplierDomain {
	/*@Override
	public String toString() {
		return "SupplierDomain [id=" + id + ", description=" + description + ", name=" + name + ", logo="
				+ Arrays.toString(logo) + ", products=" + products + "]";
	}*/
	@Id
	@GeneratedValue
    private long id;
	private String description;
	private String name;
	@Lob
	private byte[] logo;
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	@OneToMany(mappedBy="supplier")
	private List <ProductDomain> products;
	
	public SupplierDomain() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ProductDomain> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDomain> products) {
		this.products = products;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SupplierDomain(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Arrays.hashCode(logo);
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
		SupplierDomain other = (SupplierDomain) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(logo, other.logo))
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
	
}