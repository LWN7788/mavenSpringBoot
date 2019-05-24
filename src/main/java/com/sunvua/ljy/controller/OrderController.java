package com.sunvua.ljy.controller;

import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.error.EmBusinessError;
import com.sunvua.ljy.model.OrderModel;
import com.sunvua.ljy.model.UserModel;
import com.sunvua.ljy.response.ReturnCommonType;
import com.sunvua.ljy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/create",method = {RequestMethod.POST})
    @ResponseBody
    public ReturnCommonType createOrder(Integer itemId, Integer amount) throws BusinessExcepiton {
        UserModel userModel=(UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if(userModel==null){
            throw new BusinessExcepiton(EmBusinessError.PARAMETER_VALDATION_ERROR, "用户未登录");
        }
        OrderModel orderModel=orderService.createOrder(userModel.getId(),itemId, amount);
        return ReturnCommonType.create(orderModel);
    }
}
