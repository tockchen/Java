package work.ccpw.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.dao.UserDao;
import work.ccpw.domain.User;
import work.ccpw.util.JDBCUtils;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-24 13:12
 **/
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        // 使用JDBC操作数据库
        // 1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
