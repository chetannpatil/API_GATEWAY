package com.chetan.springCloudGateway.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;


//@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config>
{

	private static Logger LOGGER = LogManager.getLogger(CustomFilter.class);
	
	public CustomFilter() {
		
		super(Config.class);
		LOGGER.info("\n CustomFilter -super(Config.class) = \n");
		
		
	}
	
	public static class Config 
	{
		
		static
		{
			LOGGER.info("\n CustomFilter -  static class Config  - static II-  = \n");
		}
		
		{
			LOGGER.info("\n CustomFilter -  static class Config  -II-  = \n");
		}
	}


	@Override
	public GatewayFilter apply(Config config) {
		
		LOGGER.info("\n CustomFilter -  apply -  = \n");
		//Custom Pre Filter. Suppose we can extract JWT and perform Authentication
		return (exchange, chain) -> {
			System.out.println("First pre filter" + exchange.getRequest());
			LOGGER.info("CustomFilter -  apply -First pre filter" + exchange.getRequest());
			//Custom Post Filter.Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter");
				LOGGER.info("CustomFilter -  apply -First post filter");
			}));
		};
	}
	

}
