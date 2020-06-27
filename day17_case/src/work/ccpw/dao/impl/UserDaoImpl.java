package work.ccpw.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.dao.UserDao;
import work.ccpw.domain.User;
import work.ccpw.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        // 1.定义sql
        String sql = "insert into user value(null,?,?,?,?,?,?,null,null)";
        // 2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUserById(int id) {
        // 1.定义sql
        String sql = "delete from user where id = ?";
        // 2.执行sql
        template.update(sql, id);
    }

    @Override
    public User findUserByid(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?,qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 1.定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        // 2.遍历map

        // 定义参数的集合
        List<Object> params = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && !"".equals(value)) {
                // 有值
                stringBuilder.append(" and ").append(key).append(" like ?");
                // ? 条件的值
                params.add("%" + value + "%");
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(params);
        return template.queryForObject(stringBuilder.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findUserByPage(int start, int rows, Map<String, String[]> condition) {
        // 定义模板sql
        String sql = "select * from user where 1 = 1 ";
        StringBuffer stringBuffer = new StringBuffer(sql);
        // 遍历map
        // 定义参数的集合
        List<Object> params = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuffer.append(" and ").append(key).append(" like ? ");
                // ? 条件的值
                params.add("%" + value + "%");
            }
        }
        // 添加分页的查询
        stringBuffer.append(" limit ?,? ");
        // 添加分页查询操作
        params.add(start);
        params.add(rows);
        sql = stringBuffer.toString();
        System.out.println(sql);
        System.out.println(params);
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        return userList;
    }


}
