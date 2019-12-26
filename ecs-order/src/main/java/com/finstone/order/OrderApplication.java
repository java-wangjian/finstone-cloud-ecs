/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.finstone.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
