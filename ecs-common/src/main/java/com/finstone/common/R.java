/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */

package com.finstone.common;

import java.util.*;

/**
 * Author: wangjian
 * Date:   19-12-9
 * Time:   下午4:03
 * Description:
 */
public class R {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6,7},{9}};
        boolean found = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入： ");
        int aa = sc.nextInt();
        for(int i=0;i<arr.length && !found;i++) {
            for(int j=0;j<arr[i].length;j++){
                System.out.println("i=" + i + ",j=" + j);
                if(arr[i][j]  == aa){
                    found = true;
                    break;
                }
            }
        }
    }
}
