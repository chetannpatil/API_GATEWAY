package com.chetan.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

////either use this bean population or decalare  @Bean anotated method in  @SpringBootApplication  class 
//@Configuration
public class PreFilter extends ZuulFilter
{

    private static Logger LOGGER = LogManager.getLogger(PreFilter.class);
	
	
	
	@Override
	public boolean shouldFilter() 
	{
		LOGGER.info("\n\n PreFilter - shouldFilter yes\n\n");
		
		return true;
	}



	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n PreFilter - filterType \n\n");
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n PreFilter - filterOrder = 1 \n\n");
		
		return 1;
	}
	
	@Override
	public Object run() throws ZuulException {
		
		LOGGER.info("\n\n PreFilter - run\n\n");
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		
		HttpServletRequest httpServletRequest = requestContext.getRequest();
		
		
		LOGGER.info("\n\n PreFilter - run- method = \n\n"+httpServletRequest.getMethod());
		
		LOGGER.info("\n URL= \n "+httpServletRequest.getRequestURL().toString());
		
		return null;
	}

}
