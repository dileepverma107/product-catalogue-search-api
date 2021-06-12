package com.productcatologue.services.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productcatologue.services.Exception.CustomException;
import com.productcatologue.services.repository.ProductRepository;
import com.productCatalogue.entity.Product;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/productCatalogue/products")
	public List<Product> getAllProduct(){
		List<Product> products=productRepository.findAll();
		return products;
	}
	
	enum GroupBy {

		BRAND("brand"), COLOR("color"), SIZE("size"),PRODUCT("product");
		String value;

		GroupBy(String name) {
			value = name;
		}

		String getValue() {
			return value;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/productCatalogue/products/search/{filter}/{keyword}")
	public List<Product> searchProduct(@PathVariable String filter,@PathVariable String keyword){
		GroupBy groupBy = GroupBy.valueOf(filter.toUpperCase());
		
		List<Product> searchList=productRepository.findAll();
		List<Product> newList = null;
		switch(groupBy) {
		case PRODUCT:
			newList=searchList.stream().filter(p->p.getProductName().equals(keyword)).collect(Collectors.toList());
		    break;
		case BRAND:
			newList=searchList.stream().filter(p->p.getBrandname().equals(keyword)).collect(Collectors.toList());
		    break;
		case COLOR:
			newList=searchList.stream().filter(p->p.getColurId().equals(keyword)).collect(Collectors.toList());
		    break;
		default:
			newList=null;
		}
		
		if(newList==null || newList.isEmpty()) {
			throw new CustomException("Product Not found"); 
		}
		
		return newList;
}
}
