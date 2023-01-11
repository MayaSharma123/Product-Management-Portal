package com.cts.productManagement.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cts.productManagement.dao.MerchantDao;
import com.cts.productManagement.entities.Merchant;

@Service
public class merchantServiceImpl implements merchantService, UserDetailsService {

	@Autowired
	public MerchantDao merchantDao;
	@Override
	public Merchant addUser(Merchant merchant) {
		// TODO Auto-generated method stub
		return merchantDao.save(merchant);
	}
	
	   @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Merchant existingUser = merchantDao.findByEmail(email).orElseThrow(() ->
	                new UsernameNotFoundException("Merchant not found"));
	        return new org.springframework.security.core.userdetails.User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());

	    }

}
