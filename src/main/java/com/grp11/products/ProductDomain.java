package com.grp11.products;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
//import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grp11.suppliers.*;

@Entity
public class ProductDomain implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=4, max=50, message="{Size.Product.name.validation}")
	private String name;
	
	@Min(value=0, message="Min.Product.unitPrice.validation}")
	@NotNull(message= "{NotNull.Product.unitPrice.validation}")
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private long unitsInOrder;
	
	@Lob
	private Byte[] productImage;


	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supplierId")
	private SupplierDomain supplier;
	public ProductDomain() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(Byte[] productImage) {
		this.productImage = productImage;
	}

	public SupplierDomain getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDomain supplier) {
		this.supplier = supplier;
	}

	public ProductDomain(long id, String name, BigDecimal unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}


	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	
}