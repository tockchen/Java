package work.ccpw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import work.ccpw.dao.impl.AccountDaoImpl;
import work.ccpw.domain.Account;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 22:03
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreate() {
        String sql = "insert into account values(?,?)";

        jdbcTemplate.update(sql, "tuj", 45352);
    }
    @Test
    public void testUpdate() {
        String sql = "update account set money = ? where name = ?";

        jdbcTemplate.update(sql, 10000, "tome");
    }

    @Test
    public void testDelete() {
        String sql = "delete from account where name = ?";
        jdbcTemplate.update(sql, "tome");
    }

    @Test
    public void testQueryAll() {
        String sql = "select * from account";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accounts);
    }
    @Test
    public void testQueryOne(){
        String sql = "select * from account where name = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), "Andy");
        System.out.println(account);

    }
    @Test
    public void testQueryCount(){
        String sql = "select count(*) from account";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);

    }

    @Autowired
    private AccountDaoImpl accountDao;
    @Test
    public void test(){

        accountDao.in("Andy",500);
    }
}
