package com.firstsecurity.demo.service.UserServiceImpl;

import com.firstsecurity.demo.bean.Role;
import com.firstsecurity.demo.bean.User;
import com.firstsecurity.demo.dao.RoleDao;
import com.firstsecurity.demo.dao.UserDao;
import com.firstsecurity.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<Role> listRoleByUserId(int userId) {
        return roleDao.listRoleByUserId(userId);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
