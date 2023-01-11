package com.cts.productManagement.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.productManagement.entities.Merchant;

public interface merchantService {

	Merchant addUser(Merchant merchant);
	

	
}
