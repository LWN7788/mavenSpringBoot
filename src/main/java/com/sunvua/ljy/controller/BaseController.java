package com.sunvua.ljy.controller;

import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.error.EmBusinessError;
import com.sunvua.ljy.response.ReturnCommonType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerExecption(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData=new HashMap<>();
        if(ex instanceof BusinessExcepiton){
            BusinessExcepiton businessExcepiton=(BusinessExcepiton)ex;
            responseData.put("errCode",businessExcepiton.getErrorCode());
            responseData.put("errMsg",businessExcepiton.getErrorMsg());
        }
//        else {
//            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROE.getErrorCode());
//            responseData.put("errMsg",EmBusinessError.UNKNOWN_ERROE.getErrorMsg());
//        }
        return ReturnCommonType.create(responseData,"fail");
    }
}
