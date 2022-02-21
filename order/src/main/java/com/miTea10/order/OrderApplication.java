package com.miTea10.order;

import com.miTea10.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @Description: Order的spring启动类
 * @author: miTea
 * @date: 2022/2/19 4:14 下午
 **/
@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name="stock-service",configuration = RibbonConfig.class)
})
public class OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class, args);
    }
}

