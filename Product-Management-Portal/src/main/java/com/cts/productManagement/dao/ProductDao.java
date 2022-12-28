package com.cts.productManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.productManagement.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	
	

}
