package com.tinydemo.spring.cloud.sample.commons.web.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class OpenFeignConfig {

	@Bean
	public Retryer retryer() {
		// 最大请求次数3（1+2），初始间隔时间维度100毫秒，重试间隔时间5秒。
		return new Retryer.Default(100, 5, 3);
	}

//	@Bean
//	Logger.Level loggerLevel() {
//		return Logger.Level.FULL;
//	}

}
