package com.productCatalogue.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory {
	@Id
	private Integer id;
	
	@Column(name="CATEG_NAME")
	private String name;
	
	@JsonIgnoreProperties("productCategory")
	@OneToMany(mappedBy="productCategory",fetch=FetchType.LAZY)
	private Set<Product> product;

	public ProductCategory() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	

}
