package com.productcatologue.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.productCatalogue.entity.ProductBrand;

@Repository
public interface BrandRepository extends JpaRepository<ProductBrand,Integer>{

}
