package com.miTea10.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: riboon客户端式负载均衡策略配置.
 * @Caution(坑)： ribbon配置了最好不要鄂北spring扫描到，
 *               不然消费者服务以为它要对所有的服务提供者实行配置类里面的策略
 * @author: miTea
 * @date: 2022/2/21 10:36 下午
 **/
@Configuration
public class RibbonConfig {

    @Bean
    IRule iRule() {

        return new RandomRule();
    }

}

