/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.wangshi.common;

import java.util.Date;

/**
 * Author: wangjian
 * Date:   19-12-10
 * Time:   下午3:46
 * Description:
 */
public class E {
    public static void main(String[] args) {
        Date d1 = new Date(2018);
        Date d2 = new Date();
        long n1 = d1.getTime();
        long n2 = d2.getTime();
        long diff = Math.abs(n1 - n2);
        System.out.println(diff);

        diff /= 3600 * 1000 * 24;
        System.out.println(diff);
    }
}
