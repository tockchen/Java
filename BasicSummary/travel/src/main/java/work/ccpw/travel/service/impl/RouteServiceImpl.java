package work.ccpw.travel.service.impl;

import work.ccpw.travel.dao.FavoriteDao;
import work.ccpw.travel.dao.RouteDao;
import work.ccpw.travel.dao.RouteImgDao;
import work.ccpw.travel.dao.SellerDao;
import work.ccpw.travel.dao.impl.FavoriteDaoImpl;
import work.ccpw.travel.dao.impl.RouteDaoImpl;
import work.ccpw.travel.dao.impl.RouteImgDaoImpl;
import work.ccpw.travel.dao.impl.SellerDaoImpl;
import work.ccpw.travel.domain.PageBean;
import work.ccpw.travel.domain.Route;
import work.ccpw.travel.domain.RouteImg;
import work.ccpw.travel.domain.Seller;
import work.ccpw.travel.service.RouteService;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 21:28
 **/
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     * 封装PageBean
     *
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<Route>();
        // 设置当前页码
        pageBean.setCurrentPage(currentPage);
        // 设置每页显示条数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount = routeDao.findTotalCount(cid, rname);
        pageBean.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        // 设置当前页显示的数据集合
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pageBean.setList(list);

        // 设置总页数 = 总记录数 / 每页显示的条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public Route findOne(String rid) {
        // 1.根据id去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));
        // 2.根据route的id查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        // 2.1 将集合设置到route对象
        route.setRouteImgList(routeImgList);
        // 3.根据route的sid(商家的id)查询商家对象
        Seller seller = sellerDao.findBysid(route.getSid());
        // 3.1 将seller对象设置到route对象
        route.setSeller(seller);

        // 4 查询收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());

        route.setCount(count);


        return route;
    }
}
