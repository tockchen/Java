package work.ccpw.travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.travel.dao.CategoryDao;
import work.ccpw.travel.domain.Category;
import work.ccpw.travel.util.JDBCUtils;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 16:32
 **/
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        // 1.定义sql
        String sql = "select * from tab_category ORDER BY 'cid' ASC";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
