package com.productCatalogue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRODUCT")

public class Product {

	@Id
	private Integer id;

	@Column(name = "PODUCT_NAME")
	private String productname;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "SIZE")
	private String size;

	@Column(name = "BRAND_ID")
	private Integer brandId;

	@Column(name = "COLOR_ID")
	private Integer colurId;

	@Column(name = "PRODUCT_CAT_ID")
	private Integer category;
	
	private String categoryname;
	
	private String brandname;

	

	@JsonIgnore
	@JsonIgnoreProperties("product")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(insertable = false, updatable = false, name = "BRAND_ID")
	private ProductBrand productBrand;

	@JsonIgnore
	@JsonIgnoreProperties("product")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(insertable = false, updatable = false, name = "COLOR_ID")
	private ProductColour productColour;

	@JsonIgnore
	@JsonIgnoreProperties("product")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(insertable = false, updatable = false, name = "PRODUCT_CAT_ID")
	private ProductCategory productCategory;

	public Product() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productname;
	}

	public void setProductName(String name) {
		this.productname = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getColurId() {
		return colurId;
	}

	public void setColurId(Integer colurId) {
		this.colurId = colurId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public ProductBrand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(ProductBrand productBrand) {
		this.productBrand = productBrand;
	}

	public ProductColour getProductColour() {
		return productColour;
	}

	public void setProductColour(ProductColour productColour) {
		this.productColour = productColour;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getCategoryname() {
		String catName=productCategory.getName();
		return catName;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getBrandname() {
		String brand=productBrand.getName();
		return brand;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	

}
