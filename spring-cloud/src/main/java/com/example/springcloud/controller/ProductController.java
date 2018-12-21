package com.example.springcloud.controller;

import com.example.springcloud.hystrix.HystrixController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */
@RestController
public class ProductController {

    @Autowired
    private HystrixController hystrixController;

    @RequestMapping("/products")
    public String productList() {
        return hystrixController.productList();
    }
}
