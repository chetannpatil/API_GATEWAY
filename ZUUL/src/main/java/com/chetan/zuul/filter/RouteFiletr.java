package com.chetan.zuul.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

//@Configuration
public class RouteFiletr extends ZuulFilter
{

	 private static Logger LOGGER = LogManager.getLogger(RouteFiletr.class);
	 
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n RouteFiletr - shouldFilter yes\n\n");
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n RouteFiletr - run\n\n");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n RouteFiletr - filterType \n\n");
		return "ROUTE";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n RouteFiletr - filterOrder = 1\n\n");
		return 1;
	}

}
