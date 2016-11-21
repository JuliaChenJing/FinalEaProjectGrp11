package com.grp11.suppliers;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
import com.grp11.products.*;

@Entity
public class SupplierDomain {
	@Override
	public String toString() {
		return "SupplierDomain [id=" + id + ", description=" + description + ", name=" + name + ", logo="
				+ Arrays.toString(logo) + ", products=" + products + "]";
	}
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
	public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		SupplierDomain c = (SupplierDomain)ob;
		return name.equals(c.name);
	}
}