package work.ccpw.dao;

import work.ccpw.domain.Role;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 22:03
 **/
public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */
    void save(Role role);

    /**
     * 根据userid查询role
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Long id);


}
