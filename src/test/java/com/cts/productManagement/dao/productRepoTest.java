package com.cts.productManagement.dao;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import com.cts.productManagement.dao.ProductDao;
import com.cts.productManagement.entities.Product;



@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class productRepoTest {
	
	@Autowired
    private ProductDao productdao;
   
	@Test
	@DisplayName("ProductRepository")
	void testAddProductAtRepoLayer() {

		Product product=new Product();
		
		product.setId(1L);
		product.setName("Realme");
		product.setDescription("Tv");
		product.setPrice(34000);
		Product p = productdao.save(product);

        assertNotNull(p);
        assertThat(p.getId()).isNotEqualTo(null);
    
	}
    private void assertNotNull(Product p) {
		// TODO Auto-generated method stub
		
	}
    
      @Test
      @DisplayName("Find All Product")
      void tastGetAllProductAtRepoLayer() {

  		Product product=new Product();
  		
  		product.setId(1L);
  		product.setName("Realme");
  		product.setDescription("Tv");
  		product.setPrice(34000);
  		

        Product product1 = new Product();

		product1.setId(1L);
		product1.setName("Acer");
		product1.setDescription("Laptop");
		product1.setPrice(54000);
        
		productdao.save(product);
        productdao.save(product1);
        
        List<Product> list=productdao.findAll();
        assertNotNull(list);
        assertThat(list).isNotNull();
        assertEquals(2,list.size());

      }
	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
	private void assertNotNull(List<Product> list) {
		// TODO Auto-generated method stub
		
	}
    
}
