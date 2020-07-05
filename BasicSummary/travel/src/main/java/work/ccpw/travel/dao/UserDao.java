package work.ccpw.travel.dao;

import work.ccpw.travel.domain.User;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-28 21:06
 **/
public interface UserDao {
    /**
     * 根据用户名查询信息
     * @param username
     */
    User findByUsername(String username);

    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);


    User findByUsernameAndPassword(String username, String password);
}
