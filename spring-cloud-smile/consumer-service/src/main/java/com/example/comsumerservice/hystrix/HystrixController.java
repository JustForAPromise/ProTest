package com.example.comsumerservice.hystrix;

import com.example.comsumerservice.feignclient.GetRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther fanhanxi
 * @Date 2018/12/21
 * @Description:
 */
@Component
public class HystrixController implements GetRemote {

    @Override
    public String get(@RequestParam(value = "item") String item) {
        return "You get a broken item named "+item;
    }
}
