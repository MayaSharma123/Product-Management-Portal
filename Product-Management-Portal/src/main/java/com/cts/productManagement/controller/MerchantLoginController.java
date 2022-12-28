package com.cts.productManagement.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.productManagement.entities.Merchant;
import com.cts.productManagement.services.merchantService;

//@RequestMapping("/api")
@RestController
public class MerchantLoginController {
	
       @Autowired
	    private AuthenticationManager authenticationManager;

	    @PostMapping("/login")
	    public ResponseEntity<HttpStatus> login(@RequestBody Merchant merchant) throws Exception {
	       org.springframework.security.core.Authentication authObject = null;
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(merchant.getEmail(),merchant.getPassword()));
	            SecurityContextHolder.getContext().setAuthentication(authObject);
	        }
	        catch (BadCredentialsException e)
	        {
	            throw new Exception("Invalid Credentials");
	        }
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

}
