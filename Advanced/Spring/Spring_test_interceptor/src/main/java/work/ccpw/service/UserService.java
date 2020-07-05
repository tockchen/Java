package work.ccpw.service;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-04 14:45
 **/
public interface UserService {
    /**
     * 查询所有
     * @return
     */
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(String userId);

    User login(String username, String password);
}
