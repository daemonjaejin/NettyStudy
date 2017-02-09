package study.funzin.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JE on 2017-02-09.
 */
public class BeanMain {

    public static void main(String [] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");

        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();

        ExampleBean ex1 = (ExampleBean)ctx.getBean("exampleBean");
        ExampleBean2 ex2 = (ExampleBean2)ctx.getBean("exampleBean2");

        Calls calls = (Calls)ctx.getBean(Calls.class);
//        calls.callMethod();

    }



}
