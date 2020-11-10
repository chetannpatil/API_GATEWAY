package com.chetan.zuul.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.chetan.zuul.filter.ErrorFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	private static Logger LOGGER = LogManager.getLogger(SecurityConfig.class);
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(auth);
//	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		
		LOGGER.info("\n\n SecurityConfig - configure yes \n\n");
		
		System.out.println("\n\n SecurityConfig - configure yes \n\n");
		
		//super.configure(http);
		//  /pg/**
//		http.authorizeRequests()
//		.antMatchers("/pg/**")
//		.authenticated()
//		.anyRequest()
//		.permitAll();
		
//		http.authorizeRequests()
//		.anyRequest()
//		.denyAll();
		
	}
	
	
}
