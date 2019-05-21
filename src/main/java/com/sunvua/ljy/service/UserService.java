package com.sunvua.ljy.service;


import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessExcepiton;
    UserModel login(String telphone,String encrptPassword) throws BusinessExcepiton;
}
