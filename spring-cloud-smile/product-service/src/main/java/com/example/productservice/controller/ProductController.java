package com.example.productservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */
@RestController
public class ProductController {

    @RequestMapping("/get")
    public String index(@RequestParam String item){
        return "You get a item named "+item;
    }
}
