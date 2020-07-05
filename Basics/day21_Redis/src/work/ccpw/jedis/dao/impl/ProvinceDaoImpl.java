package work.ccpw.jedis.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.jedis.dao.ProvinceDao;
import work.ccpw.jedis.domain.Province;
import work.ccpw.jedis.utils.JDBCUtils;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 10:07
 **/
public class ProvinceDaoImpl implements ProvinceDao {
    /**
     * 1.声明成员变量 jdbcTemplement
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        // 1.定义sql
        String sql = "select * from province";
        // 2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
