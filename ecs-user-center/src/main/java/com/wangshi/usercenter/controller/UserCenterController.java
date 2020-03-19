package com.wangshi.usercenter.controller;

import com.wangshi.usercenter.dto.OrderDto;
import com.wangshi.usercenter.dto.UserDto;
import com.wangshi.usercenter.service.OrderService;
import com.wangshi.usercenter.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@DefaultProperties(defaultFallback = "fallback")
public class UserCenterController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * @description 获取当前用户的订单列表
     * @author xiaomianyang
     * @date 2019-07-19 13:05
     * @param
     * @return java.util.List<com.apgblogs.clouduser.dto.OrderDto>
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="500")
    },threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "101"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    })

    @GetMapping("userOrderList/{userId}")
    public Object getUserOrderList(@PathVariable String userId){
        Map<String,Object> resultMap = new HashMap<>();
        List<OrderDto> orderDtoList=orderService.getUserOrderList(userId);
        UserDto userDto = userService.getUser(userId);
        resultMap.put("user",userDto);
        resultMap.put("orderList",orderDtoList);
        return resultMap;
    }

    private Object error(String userId) {
        return "请求出错";
    }

    private Object fallback(){
        return "错误";
    }
}
