package com.miTea10.stock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 库存服务启动累
 * @author: miTea
 * @date: 2022/2/19 4:47 下午
 **/
@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {

        SpringApplication.run(StockApplication.class,args);
    }
}

