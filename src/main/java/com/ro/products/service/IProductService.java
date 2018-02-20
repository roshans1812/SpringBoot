package com.ro.products.service;

import java.util.Collection;

import com.ro.products.entity.Products;

public interface IProductService {
	public Collection<Products> getProducts();
	public Products getProduct(int id);
	public Products createProduct(Products product);
	public Products updateProduct(Products product);
	public void deleteProduct(int id);

}
