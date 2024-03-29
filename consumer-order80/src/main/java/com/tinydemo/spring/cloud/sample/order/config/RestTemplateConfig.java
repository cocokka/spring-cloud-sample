package com.tinydemo.spring.cloud.sample.order.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * replace load balancer with openFeign, because Spring Cloud integrates Eureka, Spring
 * Cloud CircuitBreaker, as well as Spring Cloud LoadBalancer to provide a load-balanced
 * http client when using Feign.
 */
// @Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.build();
	}

}
