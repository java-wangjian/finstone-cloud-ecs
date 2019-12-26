package com.finstone.usercenter.service;

import com.finstone.usercenter.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ecs-user")
public interface UserService {

    @GetMapping("{id}")
    UserDto getUser(@PathVariable String id);
}
