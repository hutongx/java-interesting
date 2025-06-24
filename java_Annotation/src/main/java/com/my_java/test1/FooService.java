package com.my_java.test1;

import com.my_java.test1.annotation.MyFancy;

public class FooService {
    @MyFancy("hello")
    public void foo() {
        System.out.println("执行 foo");
    }
}


