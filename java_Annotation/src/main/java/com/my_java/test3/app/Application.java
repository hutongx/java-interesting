package com.my_java.test3.app;

import com.my_java.test3.config.AppConfig;
import com.my_java.test3.service.DataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var svc = ctx.getBean(DataService.class);

        // 第一次调用，缓存未命中，耗时 ~2s
        System.out.println(svc.expensiveOperation("foo"));
        // 第二次调用，5秒内命中，立即返回
        System.out.println(svc.expensiveOperation("foo"));

        Thread.sleep(6_000);
        // 6秒后过期，再次调用会重新执行
        System.out.println(svc.expensiveOperation("foo"));

        ctx.close();
    }
}

