package com.productCatalogue.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BRAND")
public class ProductBrand {

	@Id
	@Column(name = "BRAND_ID")
	private int id;

	@Column(name = "BRAND_NAME")
	private String name;
	
	@JsonIgnore
	@JsonIgnoreProperties("productBrand")
	@OneToMany(mappedBy="productBrand",fetch=FetchType.LAZY)
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public ProductBrand() {

	}

	public ProductBrand(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductBrand [id=" + id + ", name=" + name + "]";
	}

}
