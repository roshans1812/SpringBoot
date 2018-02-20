package com.ro.products.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ro.products.entity.Products;

@Repository
public class ProductRepository implements IProductRepository{
	@Autowired
	 ProductJPARepository productRepository;

	@Override
	public Collection<Products> getProducts() {
		return productRepository.findAll();
	}
	@Override
	public Products getProduct(int productId) {
		return productRepository.findOne(productId);
	}
	@Override
	public Products createProduct(Products product) {
		return productRepository.save(product);
	}
	@Override
	public Products updateProduct(Products product) {
		return productRepository.save(product);
	}
	@Override
	public void deleteProduct(int productId) {
		productRepository.delete(productId);
	}

}
