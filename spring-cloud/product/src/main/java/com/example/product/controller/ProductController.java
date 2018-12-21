package com.example.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */

@RestController
public class ProductController {

    @RequestMapping("/products")
    public List<String> productList() {
        List<String> products = new ArrayList<>();
        products.add("外套");
        products.add("夹克");
        products.add("毛衣");
        products.add("T恤");
        return products;
    }
}
