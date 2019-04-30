package com.sunvua.ljy.service.impl;

import com.sunvua.ljy.dao.UserDOMapper;
import com.sunvua.ljy.dao.UserPasswordDOMapper;
import com.sunvua.ljy.daoObject.UserDO;
import com.sunvua.ljy.daoObject.UserPasswordDO;
import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.error.EmBusinessError;
import com.sunvua.ljy.model.UserModel;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    public void register(UserModel userModel) throws BusinessExcepiton {
        if(userModel==null){
            throw new BusinessExcepiton(EmBusinessError.PARAMETER_VALDATION_ERROR);
        }
        if(userModel.getName()==null||userModel.getGender()==null||userModel.getName()==null||userModel.getTelephone()==null){
            throw new BusinessExcepiton(EmBusinessError.PARAMETER_VALDATION_ERROR);
        }
        UserDO userDO=convertFormModel(userModel);
        userDOMapper.insertSelective(userDO);
//        UserPasswordDO userPasswordDO=convertFormModel1(userModel);
//        userPasswordDOMapper.insert(userPasswordDO);
    }
    private UserDO convertFormModel(UserModel userModel){
        UserDO userDO=new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }
    private UserPasswordDO convertFormModel1(UserModel userModel){
        UserPasswordDO userPasswordDO=new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
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
