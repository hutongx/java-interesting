package com.my_java.test1.aspect;

import com.my_java.test1.annotation.MyFancy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class FancyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        MyFancy ann = invocation.getMethod().getAnnotation(com.my_java.test1.annotation.MyFancy.class);
        if (ann != null) {
            // 这里就是你自定义的任意逻辑
            System.out.println("Before, value=" + ann.value());
        }
        Object result = invocation.proceed();
        // …也可以做 After 逻辑
        return result;
    }
}

