package work.ccpw.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: Entry
 * @description: Servlet入门程序
 * @author: cone
 * @create: 2020-06-21 15:19
 **/
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
