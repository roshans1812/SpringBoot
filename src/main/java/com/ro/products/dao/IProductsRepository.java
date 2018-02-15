package com.ro.products.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ro.products.entity.Products;

@Repository
public interface IProductsRepository extends CrudRepository<Products,Integer>{

} 
