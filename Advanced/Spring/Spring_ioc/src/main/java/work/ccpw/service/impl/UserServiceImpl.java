package work.ccpw.service.impl;

import work.ccpw.UserDao;
import work.ccpw.service.UserService;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 00:06
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }
}
