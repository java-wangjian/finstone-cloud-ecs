/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.finstone.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: wangjian
 * Date:   10/29/19
 * Time:   3:10 PM
 * Description:
 */

@RestController
public class TestController {

    @GetMapping("/str")
    public Object getValue(HttpServletRequest request){
        Object fusionUser = request.getSession().getAttribute("fusionUser");
        System.out.println("==================== " + fusionUser);
        return fusionUser;
    }
}
