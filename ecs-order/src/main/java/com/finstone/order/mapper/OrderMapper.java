/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finstone.order.entity.Orders;

import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
public interface OrderMapper extends BaseMapper<Orders> {

    /**
     * @description 查询该用户的所有订单
     * @author xiaomianyang
     * @date 2019-07-19 12:04
     * @param createUser
     */
    List<Orders> findByCreateUserOrderUserCreateDate(String createUser);
}
