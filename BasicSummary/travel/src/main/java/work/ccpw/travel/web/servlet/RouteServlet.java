package work.ccpw.travel.web.servlet;

import work.ccpw.travel.domain.PageBean;
import work.ccpw.travel.domain.Route;
import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.FavoriteService;
import work.ccpw.travel.service.RouteService;
import work.ccpw.travel.service.impl.FavoriteServiceImpl;
import work.ccpw.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 21:16
 **/
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService service = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        // 接受rname 线路名称
        String rname = request.getParameter("rname");
        int cid = 0;
        // 当前页码,如果不传递,则默认为第一页
        int currentPage = 1;
        // 每页显示的条数,如果不传递默认每页显示5条记录
        int pageSize = 5;
        // 2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        }
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 3. 调用service查询PageBean对象
        PageBean<Route> routePageBean = service.pageQuery(cid, currentPage, pageSize, rname);

        // 4. 将PageBean对象序列化为json对象
        writeValue(routePageBean, response);
    }

    /**
     * 根据id查询一个旅游线路的详细信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受id
        String rid = request.getParameter("rid");
        // 2.调用service查询route对象
        Route route = service.findOne(rid);
        // 3.转为json写回客户端
        writeValue(route, response);
    }

    /**
     * 判断当前登录用户是否收藏过该线路
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取线路id
        String rid = request.getParameter("rid");
        // 2. 获取当前登录的用户user
        User user = (User) request.getSession().getAttribute("user");
        // 用户id
        int uid;
        if (user == null) {
            // 用户未登录
            uid = 0;
        } else {
            // 用户已经登录
            uid = user.getUid();
        }

        // 3. 调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        // 4. 写回客户端
        writeValue(flag, response);
    }


    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.获取线路rid
        String rid = request.getParameter("rid");
        // 2. 获取当前登录的用户user
        User user = (User) request.getSession().getAttribute("user");
        // 用户id
        int uid;
        if (user == null) {
            // 用户未登录
            return;
        } else {
            // 用户已经登录
            uid = user.getUid();
        }

        // 3. 调用FavoriteService添加收藏
        favoriteService.add(rid,uid);
    }


}
