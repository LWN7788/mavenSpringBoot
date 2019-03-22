package com.sunvua.ljy.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunvua.ljy.pojo.JsonResult;
import com.sunvua.ljy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @RequestMapping("/hello")
    public User hello(){
        User user=new User();
        user.setName("小红");
        user.setAge(18);
        user.setPassword("ggsddu");
        user.setBirthday(new Date());
        return user;
    }
    @RequestMapping("/hello1")
    @ResponseBody
    public JsonResult hello1(){
        User user=new User();
        user.setName("小红");
        user.setAge(18);
        user.setPassword("ggsddu");
        user.setBirthday(new Date());
        return new JsonResult(true,"获取操作按钮成功",user);
    }
}
