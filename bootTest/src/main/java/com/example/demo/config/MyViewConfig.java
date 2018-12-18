package com.example.demo.config;

import com.example.demo.interceptor.AdminInterceptor;
import com.example.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Auther fanhanxi
 * @Date 2018/12/18
 * @Description:
 */
@Configuration
@EnableWebMvc
public class MyViewConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/admin/index").setViewName("index");
        registry.addViewController("").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }

    @Autowired
    AdminInterceptor adminInterceptor = new AdminInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        super.addInterceptors(registry);
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/login");

    }
}
