package work.ccpw.travel.dao;

import work.ccpw.travel.domain.Route;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 21:31
 **/
public interface RouteDao {
    /**
     * 根据cid查询总记录数
     *
     * @param cid
     * @return
     */
    public int findTotalCount(int cid, String rname);

    /**
     * 根据cid,start,pagesize查询当前页的数据集合
     *
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}
