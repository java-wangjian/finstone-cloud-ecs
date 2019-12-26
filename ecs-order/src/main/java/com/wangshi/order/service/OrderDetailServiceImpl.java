/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.wangshi.order.service;

import com.wangshi.order.entity.OrderDetail;
import com.wangshi.order.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@Service
@SuppressWarnings("all")
public class OrderDetailServiceImpl {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    public void saveOrderDetailList(List<OrderDetail> list){
        for (OrderDetail orderDetail : list){
            orderDetailMapper.insert(orderDetail);
        }
    }
}
