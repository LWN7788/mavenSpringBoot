package com.sunvua.ljy.service;

import com.sunvua.ljy.mapper.UserMapper;
import com.sunvua.ljy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUser(String id){
        return userMapper.getUser(id);
    }

}
