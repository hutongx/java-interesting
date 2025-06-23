package com.my_java.test2.testclass;

import com.my_java.test2.def_func.Shape;

public class Test1 {
    public static void main(String[] args) {
        Shape circle = new Shape() {
            private double radius = 5.0;

            @Override
            public double getArea() {
                return Math.PI * radius * radius;
            }
        };

        circle.display();
    }
}
