package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-25 22:45
 **/
//@WebFilter("/*")
public class FilterDemo7 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo7执行了...");
        chain.doFilter(req, resp);
        System.out.println("filterDemo7又回来了...");
    }

    @Override
    public void destroy() {

    }

}
