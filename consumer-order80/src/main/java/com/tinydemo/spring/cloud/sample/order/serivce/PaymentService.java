package com.tinydemo.spring.cloud.sample.order.serivce;

import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import com.tinydemo.spring.cloud.sample.order.entities.Pay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("payment-service")
@Component
public interface PaymentService {

	@GetMapping("/payment/{id}")
	ResultData<Pay> getPay(@PathVariable("id") Integer id);

}
