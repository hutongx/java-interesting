package com.my_java.test1.service;

import com.my_java.test1.annotation.MyFancy;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @MyFancy("hello-world")
    public void doWork() {
        System.out.println("=== 执行业务逻辑 doWork() ===");
    }
}

