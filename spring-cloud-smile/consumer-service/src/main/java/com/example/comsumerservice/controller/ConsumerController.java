package com.example.comsumerservice.controller;

import com.example.comsumerservice.feignclient.GetRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */
@RestController
public class ConsumerController {

    @Autowired
    private GetRemote getRemote;

    @RequestMapping("/get")
    public String get(@RequestParam(value = "item") String item){
        return getRemote.get(item);
    }

    @Value("${message}")
    private String message;

    @RequestMapping("/news")
    public String news(){
        return this.message;
    }
}
