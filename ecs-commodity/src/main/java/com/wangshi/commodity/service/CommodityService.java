package com.wangshi.commodity.service;

import com.wangshi.commodity.entity.Commodity;

import java.util.List;

/**
 * @Auther: wangjian
 * @Date: 2019/10/15 21:25
 * @Description:
 */
public interface CommodityService {

    Commodity saveCommodity(Commodity commodity);

    int deleteCommodity(String id);

    Commodity getCommodity(String id);

    int minusCommodityStock(String id, int quantity);

    List getCommodityList();


}
