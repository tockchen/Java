package work.ccpw.service.impl;

import work.ccpw.dao.UserDao;
import work.ccpw.service.UserService;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-02 15:49
 **/

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
