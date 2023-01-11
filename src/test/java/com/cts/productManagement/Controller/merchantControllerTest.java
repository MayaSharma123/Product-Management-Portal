package com.cts.productManagement.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.productManagement.controller.ProductController;
import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.services.ProductServices;
import com.cts.productManagement.services.merchantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductController.class)
public class merchantControllerTest {
	
	@MockBean
	private UserDetailsService userDetailsService;
	@MockBean
	private ProductServices productService;
	
	@MockBean
	private merchantService merchantservice;
	
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Add Merchant")
	public void tastAddMerchant() throws Exception {
		Merchant merchant=new Merchant();
		merchant.setFname("subham");
		merchant.setLname("kumar");
		merchant.setEmail("Subham@123");
		merchant.setPassword("1234");
		
		when(merchantservice.addUser(any(Merchant.class))).thenReturn(merchant);
		this.mockMvc.perform(post("/addMerchant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(merchant)))
		.andExpect(status().isOk());
               
    }

}
