package com.fenger.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static String in;
    public static void main2(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("lisi", "123456");
        try {
            //登录验证
            subject.login(token);
            System.out.println("登录成功");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
        } catch (UnknownAccountException e) {
            System.out.println("没有这个帐号");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println("认证状态："+ subject.isAuthenticated());
        System.out.println("user.delete："+ subject.isPermitted("user:delete"));
        System.out.println("user:update："+ subject.isPermitted("user:update"));
        System.out.println("user:create："+ subject.isPermitted("user:create"));
        //退出登录
        subject.logout();
    }
    public static void main(String[] args){
        String x1 = new Md5Hash("123456").toHex();
        System.out.println(x1);
        System.out.println(new Md5Hash(x1).toHex());
        String x2 = new Md5Hash("123456",null,2).toString();
        System.out.println(x2);
//        System.out.println(new Md5Hash(x2,null).toString());
//        System.out.println(new Md5Hash("123456").toHex());
        System.out.println(new SimpleHash("MD5","123456",null,2));
    }
}
