package work.ccpw.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.Utils.JDBCUtils;
import work.ccpw.domain.User;

/**
 * @program: Entry
 * @description: 操作数据库中User表的类
 * @author: cone
 * @create: 2020-06-21 22:56
 **/
public class UserDao {

    /**
     * 声明JDBCTemplate对象共用
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登录方法
     * @param loginuser  只有用户名和密码
     * @return user包含用户全部数据,没有查询到,返回null
     */
    public User login(User loginuser){

        try {
            // 1. 编写sql语句
            String sql = "select * from user where username = ? and password = ?";
            // 2. 调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(), loginuser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
