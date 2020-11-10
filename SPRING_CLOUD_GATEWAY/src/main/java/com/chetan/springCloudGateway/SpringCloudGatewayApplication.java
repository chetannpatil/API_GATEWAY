package com.chetan.springCloudGateway;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import com.chetan.springCloudGateway.config.GatewayConfig;

import reactor.core.publisher.Mono;


@SpringBootApplication
public class SpringCloudGatewayApplication {

	private static Logger LOGGER = LogManager.getLogger(GatewayConfig.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
		
		LOGGER.info("\n\n\n SpringCloudGatewayApplication main \n\n\n");
		
	}
	
	@Bean
	public GlobalFilter getGlobalFilter()
	{
		LOGGER.info("\n\n\n SpringCloudGatewayApplication - getGlobalFilter \n\n\n");
		
		return (exchange, chain) -> 
		{
			System.out.println("First Global filter");
			LOGGER.info("\n\n\n SpringCloudGatewayApplication - getGlobalFilter-First Global filter \n\n\n");
			return chain.filter(exchange).then(Mono.fromRunnable(() ->
			{
				System.out.println("Second Global filter");
				LOGGER.info("\n\n\n SpringCloudGatewayApplication - getGlobalFilter-Second Global filter \n\n\n");
			}));
		};
	}

}
