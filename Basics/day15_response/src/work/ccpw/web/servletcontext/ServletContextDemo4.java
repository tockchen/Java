package work.ccpw.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-22 14:47
 **/
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
               ServletContext功能
                   1. 获取MIME类型：
                   2. 域对象：共享数据
                       1. setAttribute(String name,Object value)
                       2. getAttribute(String name)
                       3. removeAttribute(String name)

                       * ServletContext对象范围：所有用户所有请求的数据
                   3. 获取文件的真实(服务器)路径

         */

        ServletContext context = this.getServletContext();

        Object ss = context.getAttribute("ss");
        System.out.println(ss);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
