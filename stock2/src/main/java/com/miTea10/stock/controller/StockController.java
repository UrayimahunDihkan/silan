package com.miTea10.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 库存
 * @author: miTea
 * @date: 2022/2/19 4:44 下午
 **/
@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduct")
    String reduct() {
        System.out.println("库存扣件1");
        return "8012--库存扣件1";
    }
}

