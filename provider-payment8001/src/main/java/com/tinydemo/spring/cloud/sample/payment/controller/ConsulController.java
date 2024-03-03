package com.tinydemo.spring.cloud.sample.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul")
public class ConsulController {

	@Value("${myInfo.name}")
	private String applicationName;

	@RequestMapping("/getInfo")
	public String getInfo(@Value("${myInfo.name}") String name) {
		return applicationName + "---" + name;
	}

}
