package com.my_java.test1.testclass;

import com.my_java.test1.def_func.Operation;

public class TestOperation {
    public static void main(String[] args) {
        // 用匿名内部类“实现”Operation 接口
        Operation multiply = new Operation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };
        System.out.println("3 × 4 = " + multiply.apply(3, 4));
    }
}

