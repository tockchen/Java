package work.ccpw.travel.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: travel
 * @description: 解决全站乱码问题，处理所有的请求
 * @author: cone
 * @create: 2020-06-28 21:09
 **/
//@WebFilter("/*")
public class CharchaterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filterChain) throws IOException, ServletException {
        // 将父接口转为子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) rep;
        // 获取请求方法
        String method = request.getMethod();
        // 解决post请求中文数据乱码问题
        if("post".equalsIgnoreCase(method)){
            request.setCharacterEncoding("utf8");
        }

        filterChain.doFilter(request,response);
        // 处理响应乱码
        response.setContentType("text/html;charset=utf8");
    }

    @Override
    public void destroy() {

    }
}
