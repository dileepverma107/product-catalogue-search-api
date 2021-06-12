package com.productcatologue.services.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productCatalogue.entity.ProductBrand;
import com.productcatologue.services.repository.BrandRepository;

@RestController
public class BrandController {

	@Autowired(required=true)
	BrandRepository brandRepository;
	
	@RequestMapping("/helloWorld")
	public String helloWorld() {
		return "Hello! World";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/products/brands")
	public List<ProductBrand> productBrand(){
		List<ProductBrand> brands = null;
		try {
		brands=brandRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return brands;
	}
}
