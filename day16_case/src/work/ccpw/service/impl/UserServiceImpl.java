package work.ccpw.service.impl;

import work.ccpw.dao.UserDao;
import work.ccpw.dao.impl.UserDaoImpl;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;

import java.util.List;

/**
 * @program: Entry
 * @description: 实现类
 * @author: cone
 * @create: 2020-06-24 13:10
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 调用Dao完成查询

        return userDao.findAll();
    }
}
