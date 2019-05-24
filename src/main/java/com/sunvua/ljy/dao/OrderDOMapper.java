package com.sunvua.ljy.dao;

import com.sunvua.ljy.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderDOMapper {
    void insertSelective(OrderModel orderModel);
}
