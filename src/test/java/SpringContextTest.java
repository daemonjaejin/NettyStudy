import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.funzin.dao.UserDao;


/**
 * Created by jin on 16. 11. 12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class SpringContextTest {

    @Autowired
    private ApplicationContext context;

    @Before
    public void setUp(){
        this.context.getBean("userDao", UserDao.class);
    }

    @Test
    public void test(){

    }

}
