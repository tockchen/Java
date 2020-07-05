package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: 具体路径拦截
 * @author: cone
 * @create: 2020-06-25 22:09
 **/
/*@WebFilter("/index.jsp")*/
/*@WebFilter("/user/*")*/
//@WebFilter("*.jsp")
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }

}
