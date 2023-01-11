package com.cts.productManagement.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cts.productManagement.controller.ProductController;
import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.entities.Product;
import com.cts.productManagement.services.ProductServices;
import com.cts.productManagement.services.merchantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductController.class)
public class productcontrollerTest {
	
	@MockBean
	private ProductServices productService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserDetailsService userDetailsService;
	
	@MockBean
	private merchantService merchantservice;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	//private Product products;
	
	private List<Product> productList1;    
	
	@Test
	@DisplayName("Add Product")
	public void test_AddProducts() throws Exception {
		Product product=new Product();
		//product.setId(111);
		product.setName("Hp");
		product.setDescription("Laptop");
		product.setPrice(35000);
		
		when(productService.addProduct(any(Product.class))).thenReturn(product);
		this.mockMvc.perform(post("/addProduct")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(product)))
		.andExpect(status().isOk());
               
    }
	
	@Test
	@DisplayName("Get All Product")
	public void testGetAllProductList() throws Exception {
   //  Product product=new Product();
     this.productList1 = new ArrayList<>(); 
     this.productList1.add(new Product(1L, "Dell", "Laptop", 32000)); 
     this.productList1.add(new Product(2L, "vivo", "Mobile", 36000)); 
  		
		
	 when(productService.productList()).thenReturn(productList1);
     this.mockMvc.perform(get("/viewProduct")
    		 .contentType(MediaType.APPLICATION_JSON))
     .andExpect(status().isOk());
   
   }
	
	

}
