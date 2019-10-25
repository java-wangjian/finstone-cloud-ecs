/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.order.controller;

import com.finstone.order.dto.UserDto;
import com.finstone.order.entity.OrderDetail;
import com.finstone.order.entity.Orders;
import com.finstone.order.service.OrderDetailServiceImpl;
import com.finstone.order.service.OrderServiceImpl;
import com.finstone.order.service.feign.CommodityServiceFeign;
import com.finstone.order.service.feign.UserServiceFeign;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@RestController
//@RefreshScope
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Value("${envName}")
    private String envName;
    
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private CommodityServiceFeign commodityServiceFeign;

    /**
     * @description 环境配置获取
     * @return java.lang.String
     */
    @GetMapping("/getEnvName")
    public String getEnvName(){
        return envName;
    }
    
    /**
     * @description 获取订单
     * @param id
     */
    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }
    
    /**
     * @description 新增订单
     * @param orders
     */
    @PostMapping
    public Orders saveOrders(@RequestBody Orders orders){
        System.out.println("------------- " + orders.getOrderDetailList().get(0));
        List<OrderDetail> orderDetailList = orders.getOrderDetailList();
        List<OrderDetail> newOrderDetailList = new ArrayList<>();
        double totalAmount = 0;
        for (OrderDetail orderDetail : orderDetailList){
            int quantity = orderDetail.getQuantity();
            double price = orderDetail.getPrice();
            orderDetail.setAmount(quantity*price);
            totalAmount += quantity*price;
            newOrderDetailList.add(orderDetail);
        }
        orders.setAmount(totalAmount);
        orderService.saveOrder(orders);
        orderDetailService.saveOrderDetailList(newOrderDetailList);
        return orders;
    }

    /**
     * @description 单个新增订单
     */
    @PostMapping("/one")
    public Orders saveOrder(@RequestBody OrderDetail saveData){
        System.out.println("-------------- " +saveData);
        List<OrderDetail> newOrderDetailList = new ArrayList<>();
        Orders orders = new Orders();
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(saveData, orderDetail);
        double totalAmount = 0;
        int quantity = saveData.getQuantity();
        double price = saveData.getPrice();
        orderDetail.setAmount(quantity*price);
        totalAmount = quantity*price;
        newOrderDetailList.add(orderDetail);
        orders.setAmount(totalAmount);
        orderService.saveOrder(orders);
        orderDetailService.saveOrderDetailList(newOrderDetailList);
        return orders;
    }


    /**
     * @description 通过用户名查询用户订单列表
     * @param createUser
     */
    @GetMapping("/orderList/{createUser}")
    public List<Orders> getOrderListByUser(@PathVariable String createUser){
        System.out.println("------------- " + createUser);
        List list = orderService.getOrderListByUser(createUser);
        return list;
    }

    /**
     * @description 购买并付款
     * @param id
     */
    @PostMapping("/pay/{id}")
    public Orders payOrder(@PathVariable String id){
        System.out.println("------------- " + id);
        Orders orders = orderService.getOrder(id);
        String username = orders.getCreateUser();
        UserDto userDto = userServiceFeign.getUser(username);
        double price = orders.getOrderDetailList().get(0).getPrice();
        int quantity = orders.getOrderDetailList().get(0).getQuantity();
        String commodityId = orders.getOrderDetailList().get(0).getCommodityId();
        double amount = price*quantity;
        commodityServiceFeign.minusCommodity(commodityId, quantity);
        double spareMoney = userServiceFeign.minusMoney(userDto.getId(), amount);
        userDto.setMoney(spareMoney);
        System.out.println("------- end ------");
        orders.setFinishDate(new Date());
        orders.setOrderStatus("1");
        return orders;
    }
}
