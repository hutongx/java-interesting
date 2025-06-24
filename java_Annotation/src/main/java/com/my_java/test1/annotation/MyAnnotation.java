package com.my_java.test1.annotation;

import java.lang.annotation.*;

// 最简单的注解定义
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MyAnnotation {
    String value();     // 必须元素
    int    count() default 1;  // 带默认值的可选元素
}

