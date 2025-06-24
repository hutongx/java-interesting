import com.my_java.test1.FooService;
import com.my_java.test2.annotation.TimeLoggerProcessor;
import com.my_java.test2.service.UserService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class Test1111 {
    
    @Test
    void test1(){
        FooService s = new FooService();
        s.foo();  // 控制台只会输出 “执行 foo”，不会因 @MyFancy 做任何额外工作
    }

    @Test
    void test2() throws Exception {
        UserService service = new UserService();
        Method saveUserMethod = UserService.class.getMethod("saveUser", String.class);
        Method normalMethod = UserService.class.getMethod("normalMethod");

        // 这个方法有@TimeLogger注解，会自动记录时间
        TimeLoggerProcessor.processWithTimeLogging(service, saveUserMethod, new Object[]{"张三"});

        System.out.println("---");

        // 这个方法没有注解，正常执行
        TimeLoggerProcessor.processWithTimeLogging(service, normalMethod, new Object[]{});
    }
}
