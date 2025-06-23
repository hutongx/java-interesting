package com.my_java.test1.testclass;

import com.my_java.test1.def_func.BasePrinter;

public class TestPrinter {
    public static void main(String[] args) {
        // 继承具体类 BasePrinter，并重写其 print 方法
        BasePrinter anonPrinter = new BasePrinter() {
            @Override
            public void print(String msg) {
                System.out.println("AnonymousPrinter: " + msg);
            }
        };
        anonPrinter.print("Hello, 匿名内部类！");


        new BasePrinter() {
            @Override
            public void print(String msg) {
                System.out.println("Another AnonymousPrinter-----: " + msg);
            }
        }.print("这是另一个匿名内部类的打印！");;
    }
}

