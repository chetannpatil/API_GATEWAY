package com.chetan.springCloudGateway.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//either via this class or via properties file we can implement spring cloud gateway
@Configuration
public class GatewayConfig {

	

	private static Logger LOGGER = LogManager.getLogger(GatewayConfig.class);
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		
		LOGGER.info("\n\n\n GatewayConfig- myRoutes-  \n\n\n");

		 return builder.routes()
	    .route(r -> r.path("/pg/**")
	    	
                .uri("http://localhost:2005/")
                .id("pgMicorService"))

        .route(r -> r.path("/mypg/**")
        		
                .uri("http://localhost:2004/")
                .id("ownerMicroService"))
        
        .route(r -> r.path("/bill/**")
        		
                .uri("http://localhost:2001/")
                .id("billMicroService"))
        
        .build();
	}
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		
//		LOGGER.info("\n\n\n GatewayConfig- myRoutes-  \n\n\n");
//
//		 return builder.routes()
//	    .route(r -> r.path("/pg/**")
//	    		.filters(f -> f.addRequestHeader("first-request", "first-request-header")
//						.addResponseHeader("first-response", "first-response-header"))
//                .uri("http://localhost:2005/")
//                .id("pgMicorService"))
//
//        .route(r -> r.path("/mypg/**")
//        		.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//						.addResponseHeader("second-response", "second-response-header"))
//                .uri("http://localhost:2004/")
//                .id("ownerMicroService"))
//        
//        .route(r -> r.path("/bill/**")
//        		.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//						.addResponseHeader("second-response", "second-response-header"))
//                .uri("http://localhost:2004/")
//                .id("ownerMicroService"))
//        
//        .build();
//	}
	

}
