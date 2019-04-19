package com.sunvua.ljy.dao;

import com.sunvua.ljy.daoObject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDOMapper {
    UserDO selectByPrimaryKey(Integer id);
}
