package com.firstsecurity.demo.security.detail;

import com.firstsecurity.demo.bean.Role;
import com.firstsecurity.demo.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class VUserDetail extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    //用户角色列表
    private List<Role> roleList = null;


    //用户资源权限列表
    /**
     * 注意后边的这两个参数：sRoleList、sPermissionList
     */
    public VUserDetail(User user, List<Role> roleList) {
        super(user);
        this.roleList  =roleList;
    }
    /**
     * 获取用户权限列表方法
     * 可以理解成，返回了一个List<String>，之后所谓的权限控制、鉴权，其实就是跟这个list里的String进行对比
     * 这里处理了角色和资源权限两个列表，可以这么理解，
     * 角色是权限的抽象集合，是为了更方便的控制和分配权限，而真正颗粒化细节方面，还是需要资源权限自己来做
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        StringBuilder authoritiesBuilder = new StringBuilder("");
        List<Role> tempRoleList = this.getRoleList();
        if (null != tempRoleList) {
            for (Role role : tempRoleList) {
                authoritiesBuilder.append(",").append(role.getRole());
            }
        }
        String authoritiesStr = "";
        if(authoritiesBuilder.length()>0) {
            authoritiesStr = authoritiesBuilder.deleteCharAt(0).toString();
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesStr);
    }

    @Override
    public String getPassword() {
        return super.getPwd();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    /**
     * 判断账号是否已经过期，默认没有过期
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 判断账号是否被锁定，默认没有锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断信用凭证是否过期，默认没有过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账号是否可用，默认可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
