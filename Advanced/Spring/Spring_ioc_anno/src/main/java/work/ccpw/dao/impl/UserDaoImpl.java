package work.ccpw.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import work.ccpw.dao.UserDao;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 13:17
 **/
// <bean id="userDao" class="work.ccpw.dao.impl.UserDaoImpl"/>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao save running....");
    }
}
