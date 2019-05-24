package com.sunvua.ljy.service.impl;

import com.sunvua.ljy.dao.ItemDOMapper;
import com.sunvua.ljy.dao.ItemStockDOMapper;
import com.sunvua.ljy.dao.OrderDOMapper;
import com.sunvua.ljy.daoObject.ItemDO;
import com.sunvua.ljy.daoObject.ItemStockDO;
import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.model.ItemModel;
import com.sunvua.ljy.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDOMapper itemDOMapper;
    @Autowired
    ItemStockDOMapper itemStockDOMapper;

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) {
        UUID.randomUUID().toString();
        ItemDO itemDO=converItemDOFromModel(itemModel);
        itemDOMapper.insert(itemDO);
        itemModel.setId(itemDO.getId());
        ItemStockDO itemStockDO=converItemStockDOFromModel(itemModel);
        itemStockDOMapper.insert(itemStockDO);
        return getItemById(itemModel.getId());
    }

    @Override
    public List<ItemModel> listItem() {
        return null;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        ItemDO itemDO=itemDOMapper.getItemById(id);
        ItemStockDO itemStockDO=itemStockDOMapper.getItemStockById(id);
        ItemModel itemModel=converModelFrom(itemDO,itemStockDO);
        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer amount) throws BusinessExcepiton {
        int affectedRow=itemStockDOMapper.decreaseStock(itemId,amount);
        if(affectedRow>0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    @Transactional
    public void increaseStock(Integer itemId, Integer amount) throws BusinessExcepiton {
        itemDOMapper.increaseStock(itemId,amount);
    }

    private ItemDO converItemDOFromModel(ItemModel itemModel){
        ItemDO itemDO=new ItemDO();
        BeanUtils.copyProperties(itemModel,itemDO);
        return itemDO;
    }
    private ItemStockDO converItemStockDOFromModel(ItemModel itemModel){
        ItemStockDO itemStockDO=new ItemStockDO();
        itemStockDO.setStock(itemModel.getStock());
        itemStockDO.setItemId(itemModel.getId());
        return itemStockDO;
    }
    private ItemModel converModelFrom(ItemDO itemDO,ItemStockDO itemStockDO){
        ItemModel itemModel=new ItemModel();
        BeanUtils.copyProperties(itemDO,itemModel);
        itemModel.setStock(itemStockDO.getStock());
        return itemModel;
    }
}
