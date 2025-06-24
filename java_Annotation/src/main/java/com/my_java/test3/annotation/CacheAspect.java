package com.my_java.test3.annotation;

import com.my_java.test3.annotation.interface_.MyCacheable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

    private final SimpleCache cache = new SimpleCache();

    @Around("@annotation(myCacheable)")
    public Object around(ProceedingJoinPoint pjp, MyCacheable myCacheable) throws Throwable {
        // 1. 生成缓存 key
        String key = buildKey(pjp, myCacheable.key());

        // 2. 尝试从缓存读取
        CacheEntry entry = cache.getEntry(key);
        if (entry != null) {
            long ttl = myCacheable.ttl();
            boolean valid = ttl <= 0 || (System.currentTimeMillis() - entry.getTimestamp() <= ttl);
            if (valid) {
                return entry.getValue();
            } else {
                cache.remove(key);
            }
        }

        // 3. 缓存未命中，执行原方法
        Object result = pjp.proceed();

        // 4. 将结果写入缓存
        cache.put(key, result);
        return result;
    }

    private String buildKey(ProceedingJoinPoint pjp, String keyExpr) {
        if (!keyExpr.trim().isEmpty()) {
            // 如果想支持 SpEL，可以引入 Spring Expression 并在这里评估
            return keyExpr;
        }
        // 默认：方法签名 + 所有参数 toString
        StringBuilder sb = new StringBuilder(pjp.getSignature().toShortString());
        for (Object arg : pjp.getArgs()) {
            sb.append(":").append(arg);
        }
        return sb.toString();
    }
}

