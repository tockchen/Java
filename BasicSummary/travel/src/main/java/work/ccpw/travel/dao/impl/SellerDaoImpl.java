package work.ccpw.travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.travel.dao.SellerDao;
import work.ccpw.travel.domain.Seller;
import work.ccpw.travel.util.JDBCUtils;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 10:47
 **/
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findBysid(int sid) {
        String sql = "select * from tab_seller where sid = ?";
        return  template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),sid);
    }
}
