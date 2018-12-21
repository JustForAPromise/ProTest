package com.example.springcloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */

@Component
public class HystrixController {

    private final RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public HystrixController(RestTemplate template){
        this.restTemplate = template;
    }

    @HystrixCommand(fallbackMethod = "fallBackProductMethod")
    public String productList(){
        List<ServiceInstance> instances = this.discoveryClient.getInstances("product-service");
        if (instances != null && instances.size() > 0){
            return this.restTemplate.getForObject(instances.get(0).getUri() + "/products", String.class);
        }
        return "";
    }

    public String fallBackProductMethod(){
        return "test";
    }
}
