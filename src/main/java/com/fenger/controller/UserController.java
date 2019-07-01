package com.fenger.controller;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.fenger.domain.User;
import com.fenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;
    @GetMapping("/user")
    @ResponseBody
    public String getUser(){
        return "userController->getUser";
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer userId){
        userService.deleteUser(userId);
        return "ok";
    }
    @PutMapping("/user")
    @ResponseBody
    public String updateUser(User user){
        userService.updateUser(user);
        return "ok";
    }
    @GetMapping("/allUser")
    @ResponseBody
    public String getAllUser(){
        List<User> userList = userService.queryAllUser(null);
        userList.forEach((user)->System.out.println(user));
        return "ok";
    }
}
