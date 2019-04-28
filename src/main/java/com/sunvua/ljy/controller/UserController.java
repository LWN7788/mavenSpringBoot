package com.sunvua.ljy.controller;

import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.error.EmBusinessError;
import com.sunvua.ljy.controller.viewObject.UserVO;
import com.sunvua.ljy.model.UserModel;
import com.sunvua.ljy.response.ReturnCommonType;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping(value = "/user",method = {RequestMethod.POST} )
public class UserController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest httpServletRequest;
    @RequestMapping("/getotp")
    @ResponseBody
    @CrossOrigin//解决跨域
    public ReturnCommonType getOtp(@RequestParam(name="telphone")String telphone){
        Random random=new Random();
        int randomInt=random.nextInt(99999);
        randomInt+=10000;
        String otpCode=String.valueOf(randomInt);
        httpServletRequest.getSession().setAttribute(telphone,otpCode);
        System.out.println("telphone="+telphone+"&otpcode="+otpCode);
        return ReturnCommonType.create(null);
    }



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

