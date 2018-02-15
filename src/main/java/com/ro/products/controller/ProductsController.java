package com.ro.products.controller;


import java.net.URISyntaxException;
import java.util.Collection;
import javax.validation.Valid;
import javax.ws.rs.core.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ro.products.dao.IProductsRepository;
import com.ro.products.entity.Products;
import com.ro.products.exception.DBException;
import com.ro.products.exception.URIException;
import com.ro.products.service.ProductService;



@RestController
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private IProductsRepository productsRepository;
		@GetMapping("/hellojsp")
		public String init() {
			return "true";
		}
		
		@RequestMapping(value="/products",method=RequestMethod.GET,produces= {"application/json","application/xml"})
		public @ResponseBody Collection<Products> getAllProduct(){
			return productService.getProducts();
		}
		
		@RequestMapping(value="/products/{productId}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
		public @ResponseBody Products getProduct(@PathVariable("productId") int productid) throws URIException{
			if((Integer)productid==null) {
				throw new URIException("Enter productId to retrieve product details"); 
			}else {
					Products product =  productService.getProduct(productid);
					if(product==null) {
						throw new URIException("No product found with Id:"+productid);
						}else {
							return product;
						}
			}
		}
		

		@RequestMapping(value="/products",method=RequestMethod.POST,consumes="application/json")
		public Response createProduct(@Valid @RequestBody Products product) throws URISyntaxException{
			if((Integer)product.getProductId()==null||product.getProductName()==null||(Double)product.getProductPrice()==null) {
				return Response.status(400).entity("Please provide all mandatory inputs").build(); 
			}
			else {
				productService.createProduct(product);
				return Response.status(201).build();
			}
			
		}
		
		@RequestMapping(value="/products/{productId}",method=RequestMethod.PUT,consumes="application/json",produces= {"application/json"})
		public Response  updateProduct(@PathVariable("productId") int productId,@Valid @RequestBody Products product) throws URIException{
			if((Integer)productId==null) 
				throw new URIException("Enter productId in URL to perform update"); 
			if((Integer)product.getProductId()==null||product.getProductName()==null||(Double)product.getProductPrice()==null) {
				throw new URIException("Please provide all mandatory inputs in body");
			}
			if(productId==product.getProductId()) {	
			 productService.updateProduct(product);
			 return Response.status(201).entity(product).build();
			}
			else
				return Response.status(200).entity("Entered Id in URL and Id in Body not same").build();
		}
			
		
		@RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
		public Response deleteProduct(@PathVariable("productId") int productid) throws URIException{
			if((Integer)productid==null) {
				throw new URIException("Enter productId to delete product details"); 
			}else {
					Products product =  productService.getProduct(productid);
					if(product==null) {
						throw new URIException("No product found with Id:"+productid);
						}else {
							productService.deleteProduct(productid);
							return Response.status(201).entity("Product with ProductId "+productid+" deleted.").build();
						}
			}
		}

		
}
