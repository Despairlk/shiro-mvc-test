package com.fenger.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("登录成功");
            System.out.println("认证状态："+ subject.isAuthenticated());
            System.out.println("user.delete："+ subject.isPermitted("user:delete"));
            System.out.println("user:update："+ subject.isPermitted("user:update"));
            System.out.println("user:create："+ subject.isPermitted("user:create"));
            return "list";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
        } catch (UnknownAccountException e) {
            System.out.println("没有这个帐号");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
       return "login";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
