package com.wangshi.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: wangjian
 * Date:   2/26/20
 * Time:   2:43 PM
 * Description:
 */
public class A {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        System.out.println(useCases);
    }

}
