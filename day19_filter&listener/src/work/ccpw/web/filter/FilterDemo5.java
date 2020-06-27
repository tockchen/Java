package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-25 22:21
 **/
// 浏览器直接请求资源时,该过滤器会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo...");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }

}
