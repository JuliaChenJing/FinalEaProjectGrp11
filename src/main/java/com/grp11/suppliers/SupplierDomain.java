package com.grp11.suppliers;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import com.grp11.products.*;

@Entity
public class SupplierDomain {
	private String name;
	@Id
	@GeneratedValue
    private long id; 
	public SupplierDomain(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="supplier")
	private List <ProductDomain> products=new ArrayList<ProductDomain>();
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
	
	public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		SupplierDomain c = (SupplierDomain)ob;
		return name.equals(c.name);
	}
}