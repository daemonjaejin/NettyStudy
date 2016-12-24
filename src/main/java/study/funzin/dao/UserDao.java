package study.funzin.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by jin on 16. 11. 12.
 */
@Repository
public class UserDao {

    public UserDao select(){
        UserDao userDao = new UserDao();
        return userDao;
    }

}
