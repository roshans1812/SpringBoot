package com.ro.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ro.products.entity.Products;

public interface ProductJPARepository  extends JpaRepository<Products,Integer>{

}
