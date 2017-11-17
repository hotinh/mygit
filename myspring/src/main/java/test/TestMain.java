package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        //获取bean
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
    }
}
