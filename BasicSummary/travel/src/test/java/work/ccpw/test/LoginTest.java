package work.ccpw.test;

import org.junit.Test;
import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.UserService;
import work.ccpw.travel.service.impl.UserServiceImpl;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 13:12
 **/
public class LoginTest {
    @Test
    public void Login(){
        User user = new User();
        user.setUsername("andykann");
        user.setPassword("andykann");
        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        System.out.println(login);
    }
}
