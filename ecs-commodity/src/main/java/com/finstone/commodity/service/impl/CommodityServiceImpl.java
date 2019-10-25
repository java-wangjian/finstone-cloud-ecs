/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finstone.commodity.entity.Commodity;
import com.finstone.commodity.mapper.CommodityMapper;
import com.finstone.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-15
 * Description:
 */

@SuppressWarnings("all")
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    RedisTemplate redisTemplate;

    final String USERNAME = "wangjian";

    /**
     * @description 查询商品
     * @param id
     */
    public Commodity getCommodity(String id){
        return commodityMapper.selectById(id);
    }

    @Override
    public int minusCommodityStock(String id, int quantity) {
        Commodity commodity = commodityMapper.selectById(id);
        int commodityStock = commodity.getCommodityStock();
        commodity.setCommodityStock(commodityStock-quantity);
        commodityMapper.updateById(commodity);
        return commodityMapper.selectById(id).getCommodityStock();
    }

    /**
     * @description 保存商品
     * @param commodity
     */
    public Commodity saveCommodity(Commodity commodity){

        String key = "commodity";
        commodity.setCreateUser(USERNAME);
        commodity.setUpdateUser(USERNAME);
        int i = commodityMapper.insert(commodity);
        if (i > 0){
            redisTemplate.delete(key);
        }
        return commodity;
    }

    @Override
    public int deleteCommodity(String id) {
        commodityMapper.deleteById(id);
        return 1;
    }


    public List getCommodityList(){
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        return commodityMapper.selectList(wrapper);
    }

}
