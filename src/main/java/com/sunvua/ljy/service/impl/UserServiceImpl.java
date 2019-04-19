package com.sunvua.ljy.service.impl;

import com.sunvua.ljy.dao.UserDOMapper;
import com.sunvua.ljy.dao.UserPasswordDOMapper;
import com.sunvua.ljy.daoObject.UserDO;
import com.sunvua.ljy.daoObject.UserPasswordDO;
import com.sunvua.ljy.model.UserModel;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id){
        UserDO userDO=userDOMapper.selectByPrimaryKey(id);
        if(userDO==null){
            return null;
        }
        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFormDataObject(userDO,userPasswordDO);
    }
    private  UserModel convertFormDataObject(UserDO userDo, UserPasswordDO userPasswordDO){
        if(userDo==null){
            return null;
        }
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDo,userModel);
        if(userPasswordDO.getEncrptPassword()!=null){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }

        return userModel;
    }
}
