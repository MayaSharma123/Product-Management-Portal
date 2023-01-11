package com.cts.productManagement.services;

import java.util.List;

import org.hamcrest.Matcher;

import com.cts.productManagement.entities.Product;


public interface ProductServices {

	public List<Product> productList();

	public Product addProduct(Product product);

	
}
