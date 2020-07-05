package work.ccpw.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.dao.RoleDao;
import work.ccpw.domain.Role;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 22:04
 **/
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Role> findAll() {
        String sql = "select * from sys_role";
        List<Role> roleList = template.query(sql, new BeanPropertyRowMapper<>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        String sql  = "insert into sys_role values (null,?,?)";
        template.update(sql,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        String sql = "select * from sys_user_role ur,sys_role su where ur.roleId = su.id and ur.userId = ? ";
        List<Role> roles = template.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
