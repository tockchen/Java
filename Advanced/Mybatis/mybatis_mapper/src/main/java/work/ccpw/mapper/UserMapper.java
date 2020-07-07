package work.ccpw.mapper;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 15:31
 **/
public interface UserMapper {
    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}
