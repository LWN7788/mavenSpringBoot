package com.sunvua.ljy.dao;

import com.sunvua.ljy.daoObject.ItemStockDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemStockDOMapper {
    void insert(ItemStockDO itemStockDO);
    ItemStockDO getItemStockById(Integer id);
    int decreaseStock(Integer itemId,Integer amount);
}
