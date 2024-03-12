package com.tinydemo.spring.cloud.sample.order.serivce.feign;

import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import com.tinydemo.spring.cloud.sample.commons.web.config.OpenFeignConfig;
import com.tinydemo.spring.cloud.sample.order.entities.Pay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "payment-service", path = "/payment", configuration = OpenFeignConfig.class)
@Component
public interface PaymentService {

	@GetMapping("/{id}")
	ResultData<Pay> getPay(@PathVariable("id") Integer id);

	@GetMapping("/timeout")
	ResultData<Void> timeout() throws InterruptedException;

}
