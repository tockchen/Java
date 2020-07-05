package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-25 21:50
 **/
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 对request对象请求消息增强
        System.out.println("filterDemo2执行了...");
        // 放行
        chain.doFilter(req, resp);
        // 对response对象的响应消息增强
        System.out.println("filterDemo2又回来了...");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
