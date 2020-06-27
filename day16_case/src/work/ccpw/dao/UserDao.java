package work.ccpw.dao;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Entry
 * @description: 用户操作的DAO
 * @author: cone
 * @create: 2020-06-24 13:11
 **/
public interface UserDao {
    public List<User> findAll();
}
