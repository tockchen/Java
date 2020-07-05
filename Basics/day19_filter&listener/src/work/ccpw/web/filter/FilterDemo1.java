package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: 过滤器快速入门程序
 * @author: cone
 * @create: 2020-06-25 21:28
 **/
/**
 * 访问所有资源之前,都会执行该过滤器
 */
//@WebFilter("/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了...");
        // 放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
