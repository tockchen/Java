package work.ccpw.factory;

import work.ccpw.Impl.UserDaoImpl;
import work.ccpw.UserDao;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 00:00
 **/
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
