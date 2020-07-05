package work.ccpw.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import work.ccpw.dao.UserDao;
import work.ccpw.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-04 14:50
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {
        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 使用原始的jdbc完成PreparedStatement的组件
                String sql = "insert into sys_user(username, email, password, phoneNum) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getPhoneNum());
                return preparedStatement;
            }
        };
        // 创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
//        String sql = "insert into sys_user(username, email, password, phoneNum) VALUES (?,?,?,?)";
//        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        // 获得生成的主键
        long userId = keyHolder.getKey().longValue();
        // 返回当前保存用户的id该id是数据库自动生成的
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        String sql = "insert into sys_user_role values(?,?)";
        for (long roleId : roleIds) {
            jdbcTemplate.update(sql, userId, roleId);
        }

    }

    @Override
    public void delUserRoleRel(String userId) {
        String sql = "delete from sys_user_role where userId = ?";
        jdbcTemplate.update(sql,userId);
    }

    @Override
    public void del(String userId) {
        String sql = "delete from sys_user where id = ?";
        jdbcTemplate.update(sql,userId);
    }
}
