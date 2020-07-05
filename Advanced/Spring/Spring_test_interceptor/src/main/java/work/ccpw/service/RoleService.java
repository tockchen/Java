package work.ccpw.service;

import work.ccpw.domain.Role;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 22:01
 **/
public interface RoleService {
    /**
     * 查询全部角色
     * @return
     */
    List<Role> list();

    /**
     * 保存角色
     * @param role
     */
    void save(Role role);
}
