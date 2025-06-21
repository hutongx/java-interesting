import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    void method(final int value, final List<String> list) {
        // value = 10; // 编译错误！不能重新赋值
        // list = new ArrayList<>(); // 编译错误！不能重新赋值

        // 但可以修改对象的内部状态
        list.add("item"); // 这是允许的
    }

    void print_(List<String> list){
        int count = 0;
        list.forEach(item -> {
            // count++; // 编译错误！必须是effectively final
            System.out.println(item + count);
        });
    }

    void printNumbers(int... numbers) {
        // numbers实际上是int[]数组
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    void processNumbers(List<? extends Number> numbers) {
        // 只能读取，不能添加（除了null）
        for (Number num : numbers) {
            System.out.println(num.doubleValue());
        }
        // numbers.add(1); // 编译错误！
    }

    @Test
    void testVarArgs() {
        printNumbers(1, 2, 3); // 可以传入任意数量的整数
        printNumbers(); // 也可以不传入任何参数
    }

    @Test
    void testProcessNumbers() {
        List<Integer> intList = List.of(1, 2, 3);
        processNumbers(intList); // 可以传入List<Integer>

        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        processNumbers(doubleList); // 可以传入List<Double>

        // processNumbers(List<String>); // 编译错误！不能传入List<String>
        // 使用场景：消费者，只读取数据
        List<Integer> intList1 = Arrays.asList(1, 2, 3);
        processNumbers(intList1); // 可以传入Integer列表
    }

    @Test
    void testTType(){
        /**
        List<Integer> ints = new ArrayList<>();
        List<Number> nums = ints;   // 如果允许，后面可以往 nums.add(3.14)
        nums.add(3.14);              // 插入一个 Double
        Integer x = ints.get(0);    // 再取出时就不是 Integer 了，类型安全被破坏！*/
        List<? super Integer> xs = new ArrayList<>();
        xs.add(123);          // ✅ 安全：Integer（或子类）都可以放
        xs.add(new Integer(3)); // ✅ 同上

        // Integer i = xs.get(0);  // ❌ 编译错误：编译器只知道这是某种 super Integer，最安全只能当 Object
        Object o = xs.get(0);   // ✅ 读到 Object 没问题

        List<Number> nums = new ArrayList<>();
        nums.add(123);       // 可以
        nums.add(0.1);
        nums.add(0);
        Number n = nums.get(0);
    }

    // 1. 计算一堆 Number 的总和
    public static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    @Test
    void testMethod() {
        double sum1 = sum(Arrays.asList(1, 2.5, 3L)); // 可以传入 List<Integer>, List<Double>, List<Long> 等

    }
}
