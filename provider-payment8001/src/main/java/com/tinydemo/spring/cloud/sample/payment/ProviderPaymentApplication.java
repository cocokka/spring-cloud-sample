package com.tinydemo.spring.cloud.sample.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({ "com.tinydemo.spring.cloud.sample.payment.mapper" })
@EnableDiscoveryClient
@RefreshScope
@Slf4j
public class ProviderPaymentApplication {

	public static void main(String[] args) {
		 log.info("hello ProviderPaymentApplication");
		SpringApplication.run(ProviderPaymentApplication.class, args);
	}

}