package work.ccpw.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.dao.AccountDao;

/**
 * @author Andy
 */
public class AccountDaoImpl implements AccountDao {



    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
    }

    @Override
    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
    }

    @Override
    public void save() {
        System.out.println("save running...");
    }
}
