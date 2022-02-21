package com.miTea10.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 订单类
 * @author: miTea
 * @date: 2022/2/18 11:19 下午
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {

        String msg = restTemplate.getForObject("http://stock-service/stock/reduct",String.class);
        System.out.println("下单成功");
        return "下单成功 " + msg;
    }
}

