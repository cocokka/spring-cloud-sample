package com.tinydemo.spring.cloud.sample.payment.controller;

import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consul")
@Slf4j
public class ConsulController {

	@Value("${myInfo.name}")
	private String infoName;

	private ConsulDiscoveryClient discoveryClient;

	@GetMapping("/getInfo")
	public String getInfo(@Value("${myInfo.name}") String name) {
		log.info("only parameter will be auto refreshed");
		return infoName + "---" + name;
	}

	@GetMapping("/services")
	public ResultData<List<ServiceInstance>> services() {
		return ResultData.success(discoveryClient.getAllInstances());
	}

}
