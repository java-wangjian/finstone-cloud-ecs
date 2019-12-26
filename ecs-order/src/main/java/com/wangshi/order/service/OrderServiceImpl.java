/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.wangshi.order.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangshi.order.entity.OrderDetail;
import com.wangshi.order.entity.Orders;
import com.wangshi.order.mapper.OrderDetailMapper;
import com.wangshi.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@Service
@SuppressWarnings("all")
public class OrderServiceImpl {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * @description 通过订单Id获取订单
     * @param id
     */
    public Orders getOrder(String id){
        if(orderMapper.selectById(id) == null){
            return null;
        }
        Orders orders = orderMapper.selectById(id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("orders_id", id);
        OrderDetail orderDetail = orderDetailMapper.selectOne(queryWrapper);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
        orders.setOrderDetailList(orderDetailList);
        return orders;
    }

    /**
     * @description 保存订单
     * @param orders
     */
    public Orders saveOrder(Orders orders){
        orders.setOrderNO(String.valueOf(System.currentTimeMillis()));

        orderMapper.insert(orders);
        return orders;
    }

    /**
     * @description 获取用户下的订单
     * @param userId
     */
    public List<Orders> getOrderListByUser(String createUser){
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("create_user", createUser);
        return orderMapper.selectList(wrapper);
    }

}
