package com.miTea10.order.config.restful;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 分布式架构中 服务之间的调用采取rest方式的调用
 * @author: miTea
 * @date: 2022/2/19 3:37 下午
 **/
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}

