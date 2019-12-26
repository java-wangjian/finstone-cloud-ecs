/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.finstone.filter.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Author: wangjian
 * Date:   10/29/19
 * Time:   2:54 PM
 * Description:
 */

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean CASFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(freportTokenFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("userInfoUrl","test.rdc.finstone.com.cn/api/current/user/info");
        registrationBean.addInitParameter("redirectUrl","/403");
        registrationBean.addInitParameter("exposeAttrs","tenantId,xzqhShort,phone,xzqh,status," +
                "gwdm,extras,id,username,email,openid,realName,sjxzqh,realname,props,isadmin");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "freportTokenFilter")
    public Filter freportTokenFilter() {
//        return new FreportTokenFilter();
        return null;
    }

}
