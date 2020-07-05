package work.ccpw.dao;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-04 14:49
 **/
public interface UserDao {

    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void del(String userId);

    void delUserRoleRel(String userId);

    User findByUsrenameAndPassword(String username, String password);
}
