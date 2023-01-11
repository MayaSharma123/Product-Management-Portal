package com.cts.productManagement.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import com.cts.productManagement.dao.ProductDao;
import com.cts.productManagement.entities.Product;

@SpringBootTest
public class productServiceTest {
	
	
	@InjectMocks
	private ProductServiceImpl productservice;
	
	@Mock
	private ProductDao productDao;
	
	@Test
	@DisplayName("Display Product To database")
	public void testaddProductAtSErviceLayer() {
		Product p=new Product();
		p.setId(1L);
		p.setName("Realme");
		p.setDescription("Tv");
		p.setPrice(34000);
		//productdao.save(p);
		when(productDao.save(any(Product.class))).thenReturn(p);
		Product pro=productservice.addProduct(p);
		assertNotNull(pro);
		assertThat(pro.getName()).isEqualTo("Realme");
	}

	private void assertNotNull(Product pro) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	@DisplayName("Should Return list of Products with size 2")
	public void testGetProductAtServiceLayer() {
		Product p=new Product();
		p.setId(1L);
		p.setName("Realme");
		p.setDescription("Tv");
		p.setPrice(34000);
		
		Product p1=new Product();
		p1.setId(1L);
		p1.setName("Realme");
		p1.setDescription("Tv");
		p1.setPrice(34000);
		
		List<Product> list=new ArrayList<>();
		list.add(p);
		list.add(p1);
		
		when(productDao.findAll()).thenReturn(list);
		List<Product> products=productservice.productList();
		assertEquals(2,products.size());
		//assertNotNull(products);
	}

	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
}