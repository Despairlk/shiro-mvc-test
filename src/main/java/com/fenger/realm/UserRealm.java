package com.fenger.realm;

import com.fenger.controller.UserController;
import com.fenger.domain.Permission;
import com.fenger.domain.Role;
import com.fenger.domain.User;
import com.fenger.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

//@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    public String getName(){
        return "UserRealm";
    }
    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.getPrimaryPrincipal();
        Integer userId = user.getUserid();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roles = this.userService.queryRoleByUserId(userId);
        List<String> permissions = this.userService.queryPermissionByUserId(userId);
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        char[] credentials = (char[]) token.getCredentials();
//        String password = credentials.toString();
        String password = new String(credentials);
        Assert.notNull(username,"用户名为空");
        List<User> list = this.userService.queryByUsername(username);
        if(null==list||list.isEmpty()){
            throw new RuntimeException("该用户不存在");
        }
        if(list.size()>1){
            throw new RuntimeException("该用户名重复");
        }
        User user = list.get(0);
//        if(!user.getUserpwd().equals(password)){
//            throw new RuntimeException("密码错误");
//        }
        System.out.println(password+":"+user.getUserpwd());
        return new SimpleAuthenticationInfo(user,user.getUserpwd(),this.getName());
    }
}
