package com.chetan.zuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

//@Configuration
public class ErrorFilter extends ZuulFilter
{

	private static Logger LOGGER = LogManager.getLogger(ErrorFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n ErrorFilter - shouldFilter yes \n\n");
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		LOGGER.info("\n\n ErrorFilter - run\n\n");
		
		
        RequestContext requestContext = RequestContext.getCurrentContext();
		
		HttpServletResponse response = requestContext.getResponse() ;
		
		
		
		LOGGER.info("\n\n ErrorFilter - run - response status = "+response.getStatus());
		
		
		LOGGER.info("\n\n ErrorFilter - run - response  = "+response);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n ErrorFilter - filterType  \n\n");
		
		return "ERROR";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n ErrorFilter - filterOrder = 1\n\n");
		return 1;
	}

}
