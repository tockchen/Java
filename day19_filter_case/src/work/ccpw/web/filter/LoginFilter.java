package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: Entry
 * @description: 登录验证的过滤器
 * @author: cone
 * @create: 2020-06-25 22:59
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 1.获取资源请求路径
        String uri = request.getRequestURI();
        // 2.判断是否包含登录相关资源路径,要注意排除掉 css,js,图片,验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/img/") || uri.contains("/checkCodeServlet") ) {
            chain.doFilter(req, resp);
        } else {
            // 不包含,验证用户是否登录
            // 4.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                // 登录了放行
                chain.doFilter(req,resp);
            }else {
                // 没有登录,跳转登录页面
                request.setAttribute("login_msg","您尚未登录,请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    @Override
    public void destroy() {

    }

}
