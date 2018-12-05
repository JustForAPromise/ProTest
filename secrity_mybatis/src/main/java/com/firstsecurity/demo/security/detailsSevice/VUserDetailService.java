package com.firstsecurity.demo.security.detailsSevice;

import com.firstsecurity.demo.bean.Role;
import com.firstsecurity.demo.bean.User;
import com.firstsecurity.demo.security.detail.VUserDetail;
import com.firstsecurity.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VUserDetailService implements UserDetailsService {

    @Autowired
    DataService dataService;
    /**
     * 根据用户输入的用户名返回数据源中用户信息的封装，返回一个UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User sUser = dataService.getUserByName(username);
        //用户角色列表
        List<Role> sRoleList = dataService.listRoleByUserId(sUser.getId());
        //用户资源权限列表
        System.out.println("用戶校驗執行完畢");

        return new VUserDetail(sUser, sRoleList);
    }

}