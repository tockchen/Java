package work.ccpw.mapper;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 16:45
 **/
public interface UserMapper {
    public void save(User user);
    public User findById(int id);
    public List<User> findAll();
}
