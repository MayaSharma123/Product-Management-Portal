package com.cts.productManagement.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.productManagement.dao.MerchantDao;
import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.entities.Product;

@SpringBootTest
public class merchantServiceTest {
	
	@MockBean
	private MerchantDao merchantDao;
	
	@Autowired
	private merchantService merchantservice;
	
	@Test
	@DisplayName("It should save the merchant to the database")
	public void testAddMerchantAtServiceLayer() {
		Merchant merchant = new Merchant();
		merchant.setId(1L);
		merchant.setFname("Sonu");
		merchant.setLname("Singh");
		merchant.setEmail("Sonusingh123@");
		merchant.setPassword("1234");
	  //  merchantDao.save(merchant);
	    
	    when(merchantDao.save(any(Merchant.class))).thenReturn(merchant);
		Merchant m=merchantservice.addUser(merchant);
		assertNotNull(m);
		assertThat(m.getFname()).isEqualTo("Sonu");
	  
	}

	private void assertNotNull(Merchant m) {
		// TODO Auto-generated method stub
		
	}

}
