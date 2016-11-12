package study.funzin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.funzin.dao.UserDao;

/**
 * Created by jin on 16. 11. 12.
 */
@Configuration
public class SpringConfigTest2 {

    @Autowired(required = true)
    private UserDao userDao;

    @Bean
//    @Value("test1")
    public UserDao test1(){
        return userDao.select();
    }

    @Bean
    public Integer test2(){
        return 2;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //    public void test(){
//        userDao.select();
//    }

}
