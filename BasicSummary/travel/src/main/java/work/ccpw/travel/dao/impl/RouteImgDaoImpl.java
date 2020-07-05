package work.ccpw.travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.travel.dao.RouteImgDao;
import work.ccpw.travel.domain.RouteImg;
import work.ccpw.travel.util.JDBCUtils;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 10:38
 **/
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return  template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }
}
