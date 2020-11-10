package com.chetan.zuul.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

//@Configuration
public class SimpleFilter extends ZuulFilter
{

	private static Logger LOGGER = LogManager.getLogger(SimpleFilter.class);
	
	
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n SimpleFilter - shouldFilter yes\n\n");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n SimpleFilter - run\n\n");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n SimpleFilter - filterType = custom - simplefiletr  \n\n");
		return "custom";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n SimpleFilter - filterOrder\n\n");
		return 3;
	}

}
