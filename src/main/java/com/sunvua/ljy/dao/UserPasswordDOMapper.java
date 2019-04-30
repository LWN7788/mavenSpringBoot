package com.sunvua.ljy.dao;

import com.sunvua.ljy.daoObject.UserPasswordDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserPasswordDOMapper {
    UserPasswordDO selectByPrimaryKey(Integer id);
    UserPasswordDO selectByUserId(Integer userId);
    void insert(UserPasswordDO userPasswordDO);
    void insertSelective(UserPasswordDO userPasswordDO);
}
