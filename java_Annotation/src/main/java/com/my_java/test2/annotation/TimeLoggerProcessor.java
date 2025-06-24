package com.my_java.test2.annotation;

import com.my_java.test2.annotation.TimeLogger;

import java.lang.reflect.Method;

// 2. 写一个处理器来读取注解并做实际工作
public class TimeLoggerProcessor {

    // 这个方法会自动记录执行时间
    public static Object processWithTimeLogging(Object target, Method method, Object[] args) throws Exception {

        // 检查方法是否有@TimeLogger注解
        if (method.isAnnotationPresent(TimeLogger.class)) {
            TimeLogger annotation = method.getAnnotation(TimeLogger.class);

            System.out.println("开始执行方法: " + annotation.value());
            long startTime = System.currentTimeMillis();

            // 执行原方法
            Object result = method.invoke(target, args);

            long endTime = System.currentTimeMillis();
            System.out.println("方法执行完成，耗时: " + (endTime - startTime) + "ms");

            return result;
        } else {
            // 没有注解，直接执行
            return method.invoke(target, args);
        }
    }
}
