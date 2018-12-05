package com.firstsecurity.demo.service;

import com.firstsecurity.demo.bean.Role;
import com.firstsecurity.demo.bean.User;

import java.util.List;

public interface DataService {

    public User getUserByName(String name);
    public List<Role> listRoleByUserId(int userId);

    List<User> listUsers();
}
