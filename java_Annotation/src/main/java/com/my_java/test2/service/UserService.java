package com.my_java.test2.service;

import com.my_java.test2.annotation.TimeLogger;

// 3. 使用注解
public class UserService {

    @TimeLogger("保存用户操作")
    public void saveUser(String username) {
        // 模拟耗时操作
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户 " + username + " 保存成功");
    }

    public void normalMethod() {
        System.out.println("这是普通方法，不会记录时间");
    }
}
