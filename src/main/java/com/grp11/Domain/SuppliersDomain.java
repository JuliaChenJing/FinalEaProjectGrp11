package com.grp11.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class SuppliersDomain {
	@Id
	@GeneratedValue
	private Long supplierId;
	private String supplierName;
	
	@Temporal(TemporalType.DATE)
	private Date activatedDate;
	
	//private List<product> listOfProduct;
	
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getActivatedDate() {
		return activatedDate;
	}
	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}
	
}
