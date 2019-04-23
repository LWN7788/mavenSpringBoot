package com.sunvua.ljy.controller;

import com.sunvua.ljy.controller.error.BusinessExcepiton;
import com.sunvua.ljy.controller.error.EmBusinessError;
import com.sunvua.ljy.controller.viewObject.UserVO;
import com.sunvua.ljy.model.UserModel;
import com.sunvua.ljy.response.ReturnCommonType;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/get")
    @ResponseBody
    public ReturnCommonType getUser(@RequestParam(name="id") Integer id) throws BusinessExcepiton{
        UserModel userModel=userService.getUserById(id);
        if(userModel==null){
            throw new BusinessExcepiton(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO=convertFormModel(userModel);
        return ReturnCommonType.create(userVO);
    }
    private UserVO convertFormModel(UserModel userModel){
        if(userModel==null){
            return null;
        }
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
