package work.ccpw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import work.ccpw.config.SpringConfiguration;
import work.ccpw.service.UserService;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 14:37
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @Test
    public void test() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
