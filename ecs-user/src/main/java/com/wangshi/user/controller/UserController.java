package com.wangshi.user.controller;

import com.wangshi.user.entity.User;
import com.wangshi.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: wangjian
 * Date:   19-10-16
 * Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Value("${envName}")
    private String envName;
    
    @Autowired
    private UserServiceImpl userService;

    /**
     * @description 环境配置获取
     * @return java.lang.String
     */
    @GetMapping("getEnvName")
    public String getEnvName(){
        return envName;
    }
    
    /**
     * @description 根据ID获取用户
     * @param id
     */
    @GetMapping("{id}")
    public User getUser(@PathVariable String id) throws Exception {
//        Thread.sleep(600);
//        int c = 2/0;
        return userService.getUser(id);
    }

    /**
     * @description 根据用户名获取用户
     * @param username
     */
    @GetMapping("/name/{username}")
    public User getUser2(@PathVariable String username) throws Exception {
        return userService.getUserByCreateUser(username);
    }
    
    /**
     * @description 保存用户
     * @param user
     */
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * @description 用户钱包扣减
     */
    @PostMapping("/{id}/{amount}")
    public double minusMoney(@PathVariable String id, @PathVariable double amount){
        return userService.minusUserMoney(id, amount);
    }

    /**
     * @description 获取所有用户
     */
    @GetMapping()
    public List getAll() throws Exception {
        return userService.getAllUsers();
    }
}
