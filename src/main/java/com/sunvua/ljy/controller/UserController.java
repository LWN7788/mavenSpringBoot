package com.sunvua.ljy.controller;

import com.sunvua.ljy.model.User;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/hello")
    public User getUser(){
        User user = userService.getUser("333");
//        System.out.println(user.getPassword());
//        System.out.println(user.getUsername());
        return user;
    }
//    @GetMapping("/hello1")
//    public JsonResult hello1(){
//        User user=new User();
//        user.setName("小红");
//        user.setAge(18);
//        user.setPassword("ggsddu");
//        user.setBirthday(new Date());
//        return new JsonResult(true,"获取操作按钮成功",user);
//    }
}
