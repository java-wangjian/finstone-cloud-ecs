package com.wangshi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: wangjian
 * Date:   2/26/20
 * Time:   2:44 PM
 * Description:
 */
public @interface Usercase {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseCase {
        public String id();
        public String description() default "no description";
    }
}
