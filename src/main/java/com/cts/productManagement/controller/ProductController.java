package com.cts.productManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.entities.Product;
import com.cts.productManagement.services.ProductServices;
import com.cts.productManagement.services.merchantService;


@RestController
public class ProductController {
	
	    @Autowired
	    private ProductServices productService;
	   

	    @PostMapping("/addProduct")
	 //   @CrossOrigin(origins="http://localhost:4200")
	   // @RequestMapping(value = "/products", method = RequestMethod.POST)
	    public Product addProduct(@RequestBody Product product)
	    {
	        return productService.addProduct(product);
	    }

	    @GetMapping("/viewProduct")
	    @CrossOrigin(origins="http://localhost:4200")
	    public List<Product> productList(){
	        return productService.productList();
	    }


		  @Autowired
		    private merchantService merchantService;
		 
		  @PostMapping("/addMerchant")
		//  @CrossOrigin(origins="http://localhost:4200")
		    public Merchant addUser(@RequestBody Merchant merchant){
		        return merchantService.addUser(merchant);
		    }
}