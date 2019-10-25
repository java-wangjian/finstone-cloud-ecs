/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.commodity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: wangjian
 * Date:   19-10-15
 * Description:
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.finstone.commodity.mapper")
@EnableCaching
public class CommodityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityApplication.class,args);
    }
}