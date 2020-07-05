package work.ccpw.dao.impl;

import work.ccpw.dao.UserDao;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-02 15:47
 **/

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
