/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.wangshi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangshi.order.entity.Orders;

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
