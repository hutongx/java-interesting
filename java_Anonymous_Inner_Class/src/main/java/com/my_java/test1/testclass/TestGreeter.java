package com.my_java.test1.testclass;

import com.my_java.test1.def_func.Greeter;

public class TestGreeter {
    public static void main(String[] args) {
        // 继承抽象类 Greeter 并实现 greet
        Greeter greeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("嗨，" + name + "！");
            }
        };
        greeter.greet("小明");
    }
}

