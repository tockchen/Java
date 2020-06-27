package work.ccpw.test;

import org.junit.Test;
import work.ccpw.dao.UserDao;
import work.ccpw.domain.User;

/**
 * @program: Entry
 * @description: 测试类
 * @author: cone
 * @create: 2020-06-21 23:23
 **/
public class UserDaoTest {

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);


    }
}
