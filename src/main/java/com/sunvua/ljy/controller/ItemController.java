package com.sunvua.ljy.controller;

import com.sunvua.ljy.model.ItemModel;
import com.sunvua.ljy.response.ReturnCommonType;
import com.sunvua.ljy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @RequestMapping("/createItem")
    public ReturnCommonType createItem(ItemModel itemModel){
        return ReturnCommonType.create(itemService.createItem(itemModel));
    }
    @RequestMapping("/getDetail")
    public ReturnCommonType getDetail(Integer id){
        itemService.getItemById(id);
        return ReturnCommonType.create(itemService.getItemById(id));
    }
}
