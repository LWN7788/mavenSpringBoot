package com.sunvua.ljy.service.impl;

import com.sunvua.ljy.dao.OrderDOMapper;
import com.sunvua.ljy.dao.SequenceDOMapper;
import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.error.EmBusinessError;
import com.sunvua.ljy.model.ItemModel;
import com.sunvua.ljy.model.OrderModel;
import com.sunvua.ljy.model.SequenceModel;
import com.sunvua.ljy.service.ItemService;
import com.sunvua.ljy.service.OrderService;
import com.sunvua.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ItemService itemService;
    @Autowired
    UserService userService;
    @Autowired
    OrderDOMapper orderDOMapper;
    @Autowired
    SequenceDOMapper sequenceDOMapper;
    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessExcepiton{
        ItemModel itemModel=itemService.getItemById(itemId);
        if(itemModel==null){
            throw new BusinessExcepiton(EmBusinessError.PARAMETER_VALDATION_ERROR);
        }
        if(amount<=0||amount>99){
            throw new BusinessExcepiton(EmBusinessError.PARAMETER_VALDATION_ERROR,"数量不对");
        }
        boolean result=itemService.decreaseStock(itemId,amount);
        if(!result){
            throw new BusinessExcepiton(EmBusinessError.STOCK_NOT_ENOUGH);
        }
        OrderModel orderModel=new OrderModel();
        orderModel.setUserId(userId);
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        orderModel.setItemPrice(new BigDecimal(itemModel.getPrice()));
        orderModel.setOrderPrice(new BigDecimal(itemModel.getPrice()).multiply(new BigDecimal(amount)));
        orderModel.setId(generateOrderNo());
        orderDOMapper.insertSelective(orderModel);
        itemService.increaseStock(itemId,amount);
        return orderModel;
    }
//    @Transactional(propagation=Propagation.REQUIRES_NEW)
    private String generateOrderNo(){
        StringBuilder stringBuilder=new StringBuilder();
        //前八位年月日
        LocalDateTime now=LocalDateTime.now();
        String nowDate=now.format(DateTimeFormatter.ISO_DATE).replace("-","");
        stringBuilder.append(nowDate);
        //中间6为
        int sequence=0;
        SequenceModel sequenceModel=sequenceDOMapper.getSequenceByName("order_info");
        sequence=sequenceModel.getCurrentValue();
        sequenceModel.setCurrentValue(sequenceModel.getCurrentValue()+sequenceModel.getStep());
        sequenceDOMapper.updateByPrimaryKeySelective(sequenceModel);
        String sequenceStr=String.valueOf(sequence);
        for(int i=0;i<6-sequenceStr.length();i++){
            stringBuilder.append(0);
        }
        stringBuilder.append(sequenceStr);
        //后2位分库分表位
        stringBuilder.append("00");
        return stringBuilder.toString();
    }



}
