package com.tinydemo.spring.cloud.sample.order.controller;

import cn.hutool.core.date.DateUtil;
import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import com.tinydemo.spring.cloud.sample.commons.web.api.ReturnCodeEnum;
import com.tinydemo.spring.cloud.sample.order.entities.Pay;
import com.tinydemo.spring.cloud.sample.order.serivce.feign.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Tag(name = "订单服务")
@Slf4j
public class OrderController {

	// private static final String PAYMENT_SERVICE_URL = "http://payment-service/payment";

	// private final RestTemplate restTemplate;

	private final PaymentService paymentService;

	@GetMapping("/{id}")
	@Operation(description = "查询订单")
	public ResultData<Pay> getOrder(@PathVariable("id") Integer id) {
		// return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/" + id,
		// ResultData.class);
		return paymentService.getPay(id);
	}

	@GetMapping("/timeout")
	@Operation(description = "测试超时")
	public ResultData<Void> timeout() {
		log.info("begin at: {}", DateUtil.now());
		ResultData<Void> resultData;
		try {
			resultData = paymentService.timeout();
		}
		catch (Exception e) {
			log.error("timeout => call api with error at {}", DateUtil.now(), e);
			return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "timeout");
		}
		return resultData;
	}

}
