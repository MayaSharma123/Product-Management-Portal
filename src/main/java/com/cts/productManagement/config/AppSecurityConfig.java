package com.cts.productManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cts.productManagement.services.merchantServiceImpl;


@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	  private  UserDetailsService userDetailsService;

	      @Override
	      protected void configure(HttpSecurity http) throws Exception {
	          http
	          .csrf()
	          .disable()
            .authorizeRequests()
            .antMatchers("/addProduct","/login","/addMerchant","/viewProduct","/v2/api-docs").permitAll()
           
            .anyRequest().authenticated()
            .and()
            .httpBasic();
	      }// @formatter:on 
	    
	      @Override
	      protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
	          auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	      }

	      @Bean
	      public PasswordEncoder passwordEncoder() {
	          return NoOpPasswordEncoder.getInstance();
	      }
	      @Bean
	      @Override
	      public AuthenticationManager authenticationManagerBean() throws Exception {
	          return super.authenticationManagerBean();
	      }


}
