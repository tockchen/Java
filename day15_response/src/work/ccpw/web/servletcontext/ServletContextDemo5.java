package work.ccpw.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-22 14:57
 **/
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         /*
               ServletContext功能
                   1. 获取MIME类型：
                   2. 域对象：共享数据
                   3. 获取文件的真实(服务器)路径
         */
        ServletContext context = this.getServletContext();

        // 获取文件的服务器路径
        // web目录下资源访问
        String realPath = context.getRealPath("/b.txt");
        System.out.println(realPath);
        // File file = new File(realPath);
        // WEB-INF目录下资源访问
        String realPath1 = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath1);
        // src目录下资源访问
        String realPath2 = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
