package com.my_java.test1.testclass;

public class Outer {
    private String name = "外部";

    public void test() {
        final int value = 42; // Java 8 后可省略 final，只要不修改即可

        // 直接 new 一个实现 Runnable 接口的匿名内部类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + name);
                System.out.println("Value = " + value);
            }
        };

        r.run();
    }

    public static void main(String[] args) {
        new Outer().test();
    }
}

