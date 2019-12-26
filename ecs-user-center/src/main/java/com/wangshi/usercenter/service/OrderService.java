package com.wangshi.usercenter.service;

import com.wangshi.usercenter.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="ecs-order")
public interface OrderService {

    @GetMapping("userOrderList/{userId}")
    List<OrderDto> getUserOrderList(@PathVariable String userId);
}
