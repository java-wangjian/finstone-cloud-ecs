package com.finstone.commodity.controller;

import com.finstone.commodity.entity.Commodity;
import com.finstone.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-15
 * Description:
 */
@RestController
@RequestMapping("/commodity")
@CrossOrigin
public class CommodityController {
    
    @Autowired
    private CommodityService commodityService;

    /**
     * @description 保存商品
     * @param commodity
     */
    @PostMapping
    public Commodity saveCommodity(@RequestBody Commodity commodity){
        return commodityService.saveCommodity(commodity);
    }

    /**
     * @description delete商品
     * @param id
     * @return int
     */
    @DeleteMapping("{id}")
    public int deleteCommodity(@PathVariable("id") String id){
        return commodityService.deleteCommodity(id);
    }

    /**
     * @description 扣除商品库存数量
     * @param id
     * @return int
     */
    @PostMapping("{id}/{quantity}")
    public String minusCommodity(@PathVariable("id") String id, @PathVariable("quantity")int quantity){
        return "数量还剩：" + commodityService.minusCommodityStock(id, quantity);
    }

    /**
     * @description 查询单个商品
     * @param id
     * @return Commodity
     */
    @GetMapping("{id}")
    public Commodity getCommodity(@PathVariable String id){
        return commodityService.getCommodity(id);
    }

    /**
     * @description 查询所有商品
     * @return int
     */
    @GetMapping
    public List commodityList(){
        List commodityList = commodityService.getCommodityList();
        return commodityList;
    }
}
