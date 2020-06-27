package work.ccpw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Entry
 * @description: 失败
 * @author: cone
 * @create: 2020-06-21 23:49
 **/
@WebServlet("/failServlet")
public class FaliServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给页面写一句话

        //设置编码
        resp.setContentType("text/html;charset=utf-8");
        //输出
        resp.getWriter().write("登录失败，用户名或密码错误");

    }
}
