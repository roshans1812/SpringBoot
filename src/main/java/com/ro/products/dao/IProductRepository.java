package com.ro.products.dao;

import java.util.Collection;

import com.ro.products.entity.Products;

public interface IProductRepository {
	public Collection<Products> getProducts();
	public Products getProduct(int productId) ;
	public Products createProduct(Products product);
	public Products updateProduct(Products product);
	public void deleteProduct(int productId);

}
