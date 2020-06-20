package work.ccpw.datasource.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.datasource.utils.JDBCUtils;

/**
 * @program: Entry
 * @description: JdbcTemplate入门
 * @author: cone
 * @create: 2020-06-19 11:58
 **/
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 1. 导入jar包
        // 2. 创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = jt.update(sql, 5);
        System.out.println(count);


    }
}
