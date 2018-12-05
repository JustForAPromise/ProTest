package com.firstsecurity.demo.controller;

import com.firstsecurity.demo.bean.User;
import com.firstsecurity.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    DataService dataService;

    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return dataService.listUsers();
    }
}
