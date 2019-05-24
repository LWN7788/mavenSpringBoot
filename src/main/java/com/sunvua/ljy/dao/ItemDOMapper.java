package com.sunvua.ljy.dao;

import com.sunvua.ljy.daoObject.ItemDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemDOMapper {
    void insert(ItemDO itemDO);
    ItemDO getItemById(Integer id);
    int increaseStock(Integer itemId,Integer amount);
}
