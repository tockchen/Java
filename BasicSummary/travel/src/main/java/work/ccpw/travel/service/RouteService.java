package work.ccpw.travel.service;

import work.ccpw.travel.domain.PageBean;
import work.ccpw.travel.domain.Route;

/**
 * @program: travel
 * @description: 线路Service
 * @author: cone
 * @create: 2020-06-29 21:26
 **/
public interface RouteService {

    /**
     * 根据类别进行分页查询
     *
     * @param cid
     * @param currentPage
     * @param PageSize
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage, int PageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
