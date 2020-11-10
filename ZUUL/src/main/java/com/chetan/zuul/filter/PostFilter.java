package com.chetan.zuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Configuration
public class PostFilter extends ZuulFilter
{

	 private static Logger LOGGER = LogManager.getLogger(PostFilter.class);
	 
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		LOGGER.info("\n\n PostFilter - shouldFilter yes\n\n");
		
		return true;
	}

	

	@Override
	public String filterType()
	{
		// TODO Auto-generated method stub
		LOGGER.info("\n\n PostFilter - filterType \n\n");
		
		return "post";
	}

	@Override
	public int filterOrder()
	{
		LOGGER.info("\n\n PostFilter - filterOrder = 1 \n\n");
		
		return 1;
	}

	@Override
	public Object run() throws ZuulException
	{
		LOGGER.info("\n\n PostFilter - run\n\n");
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		
		HttpServletResponse response = requestContext.getResponse() ;
		
		
		
		LOGGER.info("\n\n PostFilter - run - response status = "+response.getStatus());
		
		return null;
	}
	
}
