package work.ccpw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import work.ccpw.dao.UserDao;
import work.ccpw.service.UserService;

/**
 * @program: Spring
 * @description:   <bean id="userService" class="work.ccpw.service.impl.UserServiceImpl">
 *
 *                 </bean>
 * @author: cone
 * @create: 2020-07-01 13:20
 **/
//@Component("userService")
@Service("userService")
@Scope("prototype")
//@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    private  String driver;




    /**
     *  <property name="userDao" ref="userDao"/>
     */
    @Qualifier("userDao") //是按照id值从容器中进行匹配的,但是注意此处@Qualifier结合@Autowired一起使用
    @Autowired // 按照数据类型从spring容器中进行匹配,字段注入,可以单独使用
    //@Resource(name = "userDao") // 扩展包中的需要另加游标 相当于@Qualifier+@Autowired
    private UserDao userDao;
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    @Override
    public void save() {
        System.out.println(this.driver);
        userDao.save();
    }


}
