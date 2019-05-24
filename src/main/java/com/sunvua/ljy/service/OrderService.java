package com.sunvua.ljy.service;

import com.sunvua.ljy.error.BusinessExcepiton;
import com.sunvua.ljy.model.OrderModel;
import org.springframework.stereotype.Service;

public interface OrderService {
    OrderModel createOrder(Integer userId,Integer itemId,Integer amount) throws BusinessExcepiton;
}
