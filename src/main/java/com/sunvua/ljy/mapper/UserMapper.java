package com.sunvua.ljy.mapper;

import com.sunvua.ljy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getUser(String id);

}
