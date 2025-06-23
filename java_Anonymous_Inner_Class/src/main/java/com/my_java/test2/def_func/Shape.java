package com.my_java.test2.def_func;

// 场景2: 继承抽象类
public abstract class Shape {
    public abstract double getArea();

    public void display() {
        System.out.println("Area: " + getArea());
    }
}
