package com.cts.productManagement.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.productManagement.entities.Merchant;

@Repository
public interface MerchantDao  extends JpaRepository<Merchant, Long> {

	 Boolean existsByEmail(String email);
	    Optional<Merchant> findByEmail(String email);
	
}


