package work.ccpw.travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import work.ccpw.travel.dao.RouteDao;
import work.ccpw.travel.domain.Route;
import work.ccpw.travel.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 21:33
 **/
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
//        String sql = "select count(*) from tab_route where cid = ?";
        // 1.定义sql模板
        String sql = "select count(*) from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 条件们
        List params = new ArrayList();

        // 2.判断参数是否有值
        if (cid != 0){
            sb.append(" and cid = ? ");
            // 添加?对应的值
            params.add(cid);
        }

        if (rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }

        sql = sb.toString();

        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //String sql = "select * from tab_route where cid = ? limit ?,?";
        // 1.定义sql模板
        String sql = "select * from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 条件们
        List params = new ArrayList();
        // 2.判断参数是否有值

        if (cid != 0){
            sb.append(" and cid = ? ");
            // 添加?对应的值
            params.add(cid);
        }

        if (rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sb.append(" limit ?,? ");

        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
