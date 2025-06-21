import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

    // 1. 不用泛型（老式写法）

    public static boolean isEmpty1(List list) {
        return list == null || list.size() == 0;
    }

    // 2. 用通配符（推荐用于这种场景）
    public static boolean isEmpty2(List<?> list) {
        return list == null || list.size() == 0;
    }

    // 3. 用类型变量（当你需要返回相同类型时用）
    public static <T> boolean isEmpty3(List<T> list) {
        return list == null || list.size() == 0;
    }

    @Test
    void test1(){
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        System.out.println(isEmpty1(list)); // false
        System.out.println(isEmpty2(list)); // false
        System.out.println(isEmpty3(list)); // false

        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println(isEmpty1(intList)); // false
        System.out.println(isEmpty2(intList)); // false
        System.out.println(isEmpty3(intList)); // false

        List<String> emptyList = Collections.emptyList();
        System.out.println(isEmpty1(emptyList)); // true
        System.out.println(isEmpty2(emptyList)); // true
        System.out.println(isEmpty3(emptyList)); // true
    }

    // 声明了类型参数 T，返回类型是 void
    public static <T> void printAll(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    @Test
    void test2() {
        // 测试 printAll 方法
        List<String> names = Arrays.asList("Alice", "Bob");
        printAll(names);  // T 被推断为 String

        List<Integer> nums = Arrays.asList(1, 2);
        printAll(nums);  // T 被推断为 Integer
    }

    @Test
    void Stats(){
        Bag<Double> numbers = new Bag<>();

        numbers.add(1.2);
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;
        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean)*(x - mean);
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
