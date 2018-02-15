package com.ro.products.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ro.products.dao.IProductsRepository;

import com.ro.products.entity.Products;

@Service
public class ProductService {

	@Autowired
	private IProductsRepository productsRepository;

	public Collection<Products> getProducts() {
		List<Products> products = new ArrayList<Products>();
		for (Products product : productsRepository.findAll()) {
			products.add(product);
		}
		return products;

	}

	public Products getProduct(int id) {
		return productsRepository.findOne(id);
	}

/*	public void createProduct(int Pid, String pName, double pPrice) {
		Products prod = new Products(Pid, pName, pPrice);*/
	public Products createProduct(Products product){
		return productsRepository.save(product);
	}
	
	public Products updateProduct(Products product){
		
		return productsRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		productsRepository.delete(id);
	}

}
