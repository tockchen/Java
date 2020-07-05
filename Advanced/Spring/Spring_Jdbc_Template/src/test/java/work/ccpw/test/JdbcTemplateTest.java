package work.ccpw.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 21:06
 **/
public class JdbcTemplateTest {
    /**
     * 测试JdbcTemplate开发步骤
     */
    @Test
    public void testTemplate() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC");

        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源对象 知道数据库在哪
        jdbcTemplate.setDataSource(druidDataSource);
        // 设置sql语句
        String sql = "insert into account values(?,?)";
        // 执行sql操作
        int row = jdbcTemplate.update(sql, "tome", 50000);
        System.out.println(row);
        druidDataSource.close();
    }

    /**
     * spring产生模板对象
     */
    @Test
    public void testTemplateXml(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into account values(?,?)";
        int row = jdbcTemplate.update(sql, "Lisi", 30000);
        System.out.println(row);
    }
}
