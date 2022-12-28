package com.cts.productManagement.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.productManagement.dao.ProductDao;
import com.cts.productManagement.dao.MerchantDao;
import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.entities.Product;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public List<Product> productList() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}


	
	
 
}
