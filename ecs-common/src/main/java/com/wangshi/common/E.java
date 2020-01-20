/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.wangshi.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: wangjian
 * Date:   19-12-10
 * Time:   下午3:46
 * Description:
 */
public class E {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        List<String> filtered = strings.stream().filter(w -> !w.contains("abcd")).collect(Collectors.toList());
//        System.out.println(filtered);


        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered1 = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered1);
        String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }
}
