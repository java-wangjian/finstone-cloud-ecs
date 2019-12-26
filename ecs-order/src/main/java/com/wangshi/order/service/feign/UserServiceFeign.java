/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.wangshi.order.service.feign;

import com.wangshi.order.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@FeignClient(name="ecs-user", contextId = "user", url = "172.16.9.175:8083")
public interface UserServiceFeign {

    @GetMapping("/user/name/{username}")
    UserDto getUser(@PathVariable String username);

    @PostMapping("/user/{id}/{amount}")
    double minusMoney(@PathVariable String id, @PathVariable double amount);
}
