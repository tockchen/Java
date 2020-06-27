package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-25 21:57
 **/
/*@WebFilter("/*")*/
public class FilterDemo3 implements Filter {
    /**
     * 在服务器启动后,会创建filter对象,然后调用init方法,只执行一次,用于加载资源
     * @param config
     * @throws ServletException
     */
    /**
     * 每一次请求被拦截资源时,会执行,执行多次
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器关闭后,Filter对象被销毁.如果服务器是正常关闭,则会执行destroy方法,用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

}
