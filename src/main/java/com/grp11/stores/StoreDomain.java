package com.grp11.stores;
import javax.persistence.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
@Entity
public class StoreDomain {
	private String name;
	@Id
	@GeneratedValue
    private long id; 
	public StoreDomain(String name) {
		this.name = name;
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
	
	public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		StoreDomain c = (StoreDomain)ob;
		return name.equals(c.name);
	}
}