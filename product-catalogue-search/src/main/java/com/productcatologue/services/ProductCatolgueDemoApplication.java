package com.productcatologue.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.productCatalogue.entity")
public class ProductCatolgueDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatolgueDemoApplication.class, args);
	}

}
