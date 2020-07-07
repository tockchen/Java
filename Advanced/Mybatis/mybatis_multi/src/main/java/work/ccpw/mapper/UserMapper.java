package work.ccpw.mapper;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:03
 **/
public interface UserMapper {
    /**
     * 查询一个用户有那些订单
     * @return
     */
    public List<User> findAll();

    /**
     * 查询一个用户具备那些角色
     * @return
     */
    public List<User> findUserAndRoleAll();

}
