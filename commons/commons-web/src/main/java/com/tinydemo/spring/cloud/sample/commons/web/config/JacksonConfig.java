package com.tinydemo.spring.cloud.sample.commons.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.TimeZone;

@Configuration
public class JacksonConfig {
 
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return builder;
    }
}