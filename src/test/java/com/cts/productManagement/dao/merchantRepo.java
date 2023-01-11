package com.cts.productManagement.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.entities.Product;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class merchantRepo {

	@Autowired
    private MerchantDao merchantdao;
   
	@Test
	@DisplayName("MerchantRepository")
	void testAddMerchantAtRepoLayer() {

		Merchant merchant=new Merchant();
		
		merchant.setId(1L);
		merchant.setFname("Rohit");
		merchant.setLname("Mishra");
		merchant.setEmail("Rohit@123");
		merchant.setPassword("12345");
		Merchant p = merchantdao.save(merchant);

        assertNotNull(p);
        assertThat(p.getId()).isNotEqualTo(null);
    
	}

	private void assertNotNull(Merchant p) {
		// TODO Auto-generated method stub
		
	}

}
