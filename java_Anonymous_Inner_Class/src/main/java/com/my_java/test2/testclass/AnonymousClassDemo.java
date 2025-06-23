package com.my_java.test2.testclass;

import com.my_java.test2.def_func.Calculator;

public class AnonymousClassDemo {

    public static void main(String[] args) {
        // 场景1: 实现接口
        Calculator add = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        Calculator multiply = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        Calculator add_lambda = (a, b) -> a + b; // 使用Lambda表达式简化

        System.out.println("Add: " + add.calculate(5, 3));
        System.out.println("Multiply: " + multiply.calculate(5, 3));

        // 场景2: 继承抽象类
        abstract class Shape {
            abstract double getArea();

            public void display() {
                System.out.println("Area: " + getArea());
            }
        }

        Shape circle = new Shape() {
            private double radius = 5.0;

            @Override
            double getArea() {
                return Math.PI * radius * radius;
            }
        };

        circle.display();

        // 场景3: 继承具体类并重写方法
        Thread customThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Custom thread running: " + Thread.currentThread().getName());
            }
        };

        customThread.start();

        // 场景4: 事件处理模式
        processData(new DataProcessor() {
            @Override
            public String process(String data) {
                return data.toUpperCase() + "_PROCESSED";
            }
        });

        // 场景5: 访问外部变量（重要特性）
        final String prefix = "PREFIX_";  // 必须是final或effectively final
        int count = 10;  // effectively final

        Calculator prefixCalculator = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                System.out.println(prefix + "Calculating: " + a + " + " + b);
                System.out.println("Count: " + count);
                return a + b;
            }
        };

        prefixCalculator.calculate(1, 2);
    }

    // 工具接口
    interface DataProcessor {
        String process(String data);
    }

    // 工具方法
    static void processData(DataProcessor processor) {
        String result = processor.process("hello world");
        System.out.println("Processed: " + result);
    }
}
