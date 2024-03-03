package com.tinydemo.spring.cloud.sample.commons.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {

	@Bean
	public GroupedOpenApi paymentApi() {
		return GroupedOpenApi.builder().group("payment").pathsToMatch("/payment/**").build();
	}

	@Bean
	public GroupedOpenApi orderApi() {
		return GroupedOpenApi.builder().group("order").pathsToMatch("/order/**").build();
	}

	@Bean
	public GroupedOpenApi otherApi() {
		return GroupedOpenApi.builder().group("other").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("微服务").version("1.0.0").description("微服务"));
	}

}
