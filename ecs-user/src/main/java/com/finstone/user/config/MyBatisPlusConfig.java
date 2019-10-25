/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.finstone.user.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;

/**
 * Author: wangjian
 * Date:   19-10-16
 * Time:   下午2:48
 * Description:
 */
public class MyBatisPlusConfig {

    /**
     * 自动填充功能
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MetaHandler());
        return globalConfig;
    }
}
