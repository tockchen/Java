package work.ccpw.web.servlet;

import work.ccpw.service.UserService;
import work.ccpw.service.impl.UserServiceImpl;

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
 * @create: 2020-06-25 16:01
 **/
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取数据
        String[] uids = request.getParameterValues("uid");
        // 2. 调用service方法
        UserService userService = new UserServiceImpl();
        userService.delSelectedByid(uids);
        // 3. 重定向到查询所有用户信息
        response.sendRedirect("/findUserByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
