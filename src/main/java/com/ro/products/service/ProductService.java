package com.ro.products.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ro.products.dao.IProductRepository;
import com.ro.products.entity.Products;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductRepository productRepository;

	public Collection<Products> getProducts() {// 
		/*List<Products> products = new ArrayList<Products>();
		for (Products product : productsRepository.findAll()) {
			products.add(product);
		}*/
		return productRepository.getProducts();

	}

	public Products getProduct(int productId){		
		return productRepository.getProduct(productId);
	}


	public Products createProduct(Products product){
		return productRepository.createProduct(product);
	}
	
	public Products updateProduct(Products product){
		
		return productRepository.updateProduct(product);
	}
	
	public void deleteProduct(int productId) {
		productRepository.deleteProduct(productId);
	}

}
