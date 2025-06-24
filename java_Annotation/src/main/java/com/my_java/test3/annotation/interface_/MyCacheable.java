package com.my_java.test3.annotation.interface_;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCacheable {
    /**
     * 缓存 key 的前缀或 SpEL 表达式，留空则用方法签名+参数自动生成
     */
    String key() default "";
    /**
     * 过期时间，单位毫秒；<=0 表示不过期
     */
    long ttl() default -1L;
}

