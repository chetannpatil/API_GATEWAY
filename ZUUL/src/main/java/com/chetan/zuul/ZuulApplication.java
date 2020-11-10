package com.chetan.zuul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.chetan.zuul.filter.PreFilter;

@SpringBootApplication
//@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication 
{

	private static Logger LOGGER = LogManager.getLogger(ZuulApplication.class);
	
	public static void main(String[] args)
	{
		
		LOGGER.info("\n\n ZuulApplication - main\n\n");
		
		System.out.println("\n\n ZuulApplication - main\n\n");
		
		SpringApplication.run(ZuulApplication.class, args);
	}
	
	//either use this bean population or use @Configuration on PreFilter class 
	@Bean
	public PreFilter getPreFilter()
	{
		LOGGER.info("\n\n ZuulApplication - getPreFilter\n\n");
		
		System.out.println("\n\n ZuulApplication - getPreFilter\n\n");
		
		return new PreFilter();
	}

}
