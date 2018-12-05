package com.firstsecurity.demo.security.authenticationProvider;

import com.firstsecurity.demo.security.detail.VUserDetail;
import com.firstsecurity.demo.security.detailsSevice.VUserDetailService;
import com.firstsecurity.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class VAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private VUserDetailService vUserDetailsService;
    /**
     * 首先，在用户登录的时候，系统将用户输入的的用户名和密码封装成一个Authentication对象
     * 然后，根据用户名去数据源中查找用户的数据，这个数据是封装成的VUserDetails对象
     * 接着，将两个对象进行信息比对，如果密码正确，通过校验认证
     * 最后，将用户信息（含身份信息、细节信息、密码、权限等）封装成一个对象，此处参考UsernamePasswordAuthenticationToken
     * 最最后，会将这个对象交给系统SecurityContextHolder中（功能类似Session），以便后期随时取用
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        VUserDetail vUserDetails = (VUserDetail)vUserDetailsService.loadUserByUsername(username);

        if(vUserDetails == null){
            throw new UsernameNotFoundException("用户没有找到");
        }
        if (!password.equals(vUserDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(vUserDetails, password, vUserDetails.getAuthorities());

        System.out.println(token.getName()+"    "+token.getAuthorities());
        //认证校验通过后，封装UsernamePasswordAuthenticationToken返回
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}