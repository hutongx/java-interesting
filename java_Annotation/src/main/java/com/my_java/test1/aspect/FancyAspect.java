package com.my_java.test1.aspect;

import com.my_java.test1.annotation.MyFancy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FancyAspect {

    // 匹配所有被 @MyFancy 注解标记的方法
    @Around("@annotation(myFancy)")
    public Object around(ProceedingJoinPoint pjp, MyFancy myFancy) throws Throwable {
        // Before 逻辑
        System.out.println(">>> Before, value = " + myFancy.value());
        long start = System.currentTimeMillis();

        // 调用原方法
        Object result = pjp.proceed();

        // After 逻辑
        long duration = System.currentTimeMillis() - start;
        System.out.println("<<< After, method " +
                pjp.getSignature().getName() +
                " executed in " + duration + " ms");
        return result;
    }
}
