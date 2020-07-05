package work.ccpw.factory;

import work.ccpw.Impl.UserDaoImpl;
import work.ccpw.UserDao;

/**
 * @program: Spring
 * @description: 静态工厂
 * @author: cone
 * @create: 2020-06-30 23:55
 **/
public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
