package com.tinydemo.spring.cloud.sample.order.controller;

import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Tag(name = "订单服务")
public class OrderController {

	private static final String PAYMENT_SERVICE_URL = "http://payment-service/payment";

	private final RestTemplate restTemplate;

	@GetMapping("/{id}")
	@Operation(description = "查询订单")
	public ResultData<Object> getOrder(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/" + id, ResultData.class);
	}
}
