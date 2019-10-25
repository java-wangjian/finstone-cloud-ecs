package com.finstone.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finstone.user.entity.User;
import com.finstone.user.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author: wangjian
 * Date:   19-10-16
 * Description:
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl {

    final String USERNAME = "wangjian";

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;
    
    /**
     * @description 通过用户Id获取用户
     * @param id
     */
    public User getUser(String id){
        long start = System.currentTimeMillis();
        System.out.println("start " + start);
        String key = "user_" + id;
        boolean haskey = redisTemplate.hasKey(key);
        System.out.println("hashkey=========== " + haskey);
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        if (haskey){
            User user = operations.get(key);
            System.out.println("UserServiceImpl.getUser() : 从缓存取得数据 >> " + user.toString());
            System.out.println("redis end " + (System.currentTimeMillis() - start));
            return user;
        }

        User user = userMapper.selectById(id);
        operations.set(key, user, 10, TimeUnit.SECONDS);
        System.out.println("UserServiceImpl.getUser() : 用户信息插入缓存 >> " + operations.get(key));
        System.out.println("mysql end " + (System.currentTimeMillis() - start));
        return user;
    }

    /**
     * @description 通过用户 createUser 获取用户
     * @param username
     */
    public User getUserByCreateUser(String username){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("username", username);
        if(userMapper.selectOne(queryWrapper) == null){
            return null;
        }
        return userMapper.selectOne(queryWrapper);
    }
    
    /**
     * @description 保存用户
     * @param user
     */
    public User saveUser(User user){
        if(StringUtils.isEmpty(user)){
            return null;
        }
        user.setCreateUser(USERNAME);
        user.setUpdateUser(USERNAME);
        userMapper.insert(user);
        return user;
    }

    /**
     * @description 用户钱包扣减
     * @param id
     */
    public double minusUserMoney(String id, double amount){
        User user = userMapper.selectById(id);
        double preMoney = user.getMoney();
        double newMoney = preMoney - amount;
        user.setMoney(newMoney);
        userMapper.updateById(user);
        return user.getMoney();
    }


    /**
     * @description 获取所有用户
     * @param id
     */
    public List getAllUsers(){
        QueryWrapper queryWrapper = new QueryWrapper();
        return userMapper.selectList(queryWrapper);
    }
}
