package com.camilo.api.gateway.config;

import com.camilo.api.gateway.filters.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
	
		@Autowired
		private AuthenticationFilter filter;

		@Bean
		public RouteLocator routes(RouteLocatorBuilder builder) {
			return builder.routes()
					.route("login", r -> r.path("/login/**").filters(f -> f.filter(filter)).uri("lb://Security"))
					.route("users", r -> r.path("/users/**").filters(f -> f.filter(filter)).uri("lb://Users"))
					.build();
		}
}
