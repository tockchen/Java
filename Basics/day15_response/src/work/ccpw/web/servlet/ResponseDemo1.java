package work.ccpw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-22 12:13
 **/
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo1....");
        /*// 访问/responseDemo1,会自动跳转到/responseDemo2资源
        // 1. 设置状态码为302
        resp.setStatus(302);
        // 2. 设置响应头location
        resp.setHeader("location","/responseDemo2");*/

        // 动态获取虚拟目录
        String contextPath = req.getContextPath();

        resp.sendRedirect(contextPath+"/responseDemo2");
//        resp.sendRedirect("https://www.baidu.com");

    }
}
