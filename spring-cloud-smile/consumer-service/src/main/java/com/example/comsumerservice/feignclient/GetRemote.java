package com.example.comsumerservice.feignclient;

import com.example.comsumerservice.hystrix.HystrixController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */
@FeignClient(name = "product-service", fallback = HystrixController.class)
@Component
public interface GetRemote {

    @RequestMapping(value = "/get")
    public String get(@RequestParam(value = "item") String item);
}
