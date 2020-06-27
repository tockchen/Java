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
 * @create: 2020-06-25 12:41
 **/
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取id
        String id = request.getParameter("id");
        // 2.调用service
        UserService userService = new UserServiceImpl();
        userService.deleteUserById(id);

        // 3.跳转到查询所有userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
