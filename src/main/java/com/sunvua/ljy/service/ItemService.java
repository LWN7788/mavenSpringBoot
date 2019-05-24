package com.sunvua.ljy.service;

import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.model.ItemModel;

import java.util.List;

public interface ItemService {
    ItemModel createItem(ItemModel itemModel);
    List<ItemModel> listItem();
    ItemModel getItemById(Integer id);
    boolean decreaseStock(Integer itemId,Integer amount) throws BusinessExcepiton;
    void increaseStock(Integer itemId,Integer amount) throws BusinessExcepiton;
}
