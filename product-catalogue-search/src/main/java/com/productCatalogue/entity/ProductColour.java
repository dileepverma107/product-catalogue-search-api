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
@Table(name="COLOR")
public class ProductColour {
	
@Id
@Column(name="COLOR_ID")
private int id;

@Column(name="COLOR_NAME")
private String name;
private String code;

@JsonIgnoreProperties("productColour")
@OneToMany(mappedBy="productColour",fetch=FetchType.LAZY)
private Set<Product> products;

public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}
public ProductColour() {
	
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

}
