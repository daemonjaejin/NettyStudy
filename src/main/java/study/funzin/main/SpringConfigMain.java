package study.funzin.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import study.funzin.config.SpringConfigTest;
import study.funzin.config.SpringConfigTest2;
import study.funzin.dao.UserDao;
import study.funzin.service.SpringTestService;

/**
 * Created by jin on 16. 11. 12.
 */
public class SpringConfigMain {

    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestService.class);
        Integer result = context.getBean("testDao", Integer.class);
//        Integer result = (Integer)context.getBean("testDao");
//        Object result = context.getBean("testDao");
        System.out.println("result : " + result);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(SpringConfigTest.class);
        Integer result1 = context1.getBean("test1", Integer.class);
        System.out.println("result1 : " + result1);

//        ApplicationContext context2 = new AnnotationConfigApplicationContext(SpringConfigTest2.class);
//        Integer result2 = context2.getBean("test1", Integer.class);
//        System.out.println("result2 : " + result2);

//        ApplicationContext context2 = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context2 = new GenericXmlApplicationContext("spring-context.xml");
        System.out.println("getApplicationName : " + context2.getDisplayName());
        System.out.println("getParentBeanFactory : " + context2.getParentBeanFactory());

        UserDao userDao = context2.getBean("userDao", UserDao.class);
        System.out.println("userDao : " + userDao);

    }

}
