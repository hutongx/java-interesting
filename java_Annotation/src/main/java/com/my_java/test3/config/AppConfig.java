package com.my_java.test3.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.my_java")
@EnableAspectJAutoProxy  // 启用 @Aspect 注解驱动的 AOP
public class AppConfig { }

