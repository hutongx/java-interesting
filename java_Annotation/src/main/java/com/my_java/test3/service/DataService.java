package com.my_java.test3.service;

import com.my_java.test3.annotation.interface_.MyCacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    /** 模拟耗时计算/IO */
    @MyCacheable(ttl = 5_000)
    public String expensiveOperation(String param) throws InterruptedException {
        Thread.sleep(2000);  // 模拟延迟
        return "Result for " + param + " at " + System.currentTimeMillis();
    }
}

