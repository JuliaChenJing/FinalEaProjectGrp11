package com.grp11.products;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
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
import com.grp11.category.CategoryDomain;
import com.grp11.suppliers.*;

@Entity
public class ProductDomain implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String name;

	private int unitPrice;
	private String description;
	private String manufacturer;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private CategoryDomain category;
	private long unitsInStock;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supplierId")
	private SupplierDomain supplier;
	@Lob
	private byte[] productImage;
	@Transient
	private String base64Image;
	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public ProductDomain() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public SupplierDomain getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDomain supplier) {
		this.supplier = supplier;
	}

	public ProductDomain(long id, String name, int unitPrice) {
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

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
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

	public CategoryDomain getCategory() {
		return category;
	}

	public void setCategory(CategoryDomain category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	/*@Override
	public String toString() {
		return "ProductDomain [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", supplier=" + supplier + ", productImage=" + Arrays.toString(productImage) + "]";
	}*/
	
	
	
}