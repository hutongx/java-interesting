package com.my_java;

import com.my_java.test1.config.AppConfig;
import com.my_java.test1.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 启动 Spring 容器
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 拿到被代理的 Bean，执行方法
        MyService svc = ctx.getBean(MyService.class);
        svc.doWork();

        ctx.close();
    }
}

