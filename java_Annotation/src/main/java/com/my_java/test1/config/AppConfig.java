package com.my_java.test1.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.my_java")
@EnableAspectJAutoProxy  // 启用基于注解的 AOP 自动代理
public class AppConfig {
}

