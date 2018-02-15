package com.ro.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="products")
public class Products {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="products_id")
	private int productId;
	
	@Column(name="products_name")
	private String productName;
	
	@Column(name="products_price")
	private double productPrice;
	
	public Products() {
		
	}
	
	public Products(int id,String name, double productPrice) {
		this.productId = id;
		this.productName = name;
		this.productPrice=productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	
	
	

}
