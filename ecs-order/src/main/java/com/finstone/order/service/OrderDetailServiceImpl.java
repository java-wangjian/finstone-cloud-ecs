/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.order.service;

import com.finstone.order.entity.OrderDetail;
import com.finstone.order.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
