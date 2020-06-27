package work.ccpw.web.servlet;

import work.ccpw.domain.PageBean;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;
import work.ccpw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-25 16:54
 **/
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取参数
        // 当前页码
        String currentPage = request.getParameter("currentPage");
        // 每页显示的条目
        String rows = request.getParameter("rows");
        if (currentPage == null || " ".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || " ".equals(rows)) {
            rows = "2";
        }


        // 获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();


        // 2.调用service查询
        UserService userService = new UserServiceImpl();
        PageBean<User> pageUsers = userService.findUserByPage(currentPage, rows, condition);
        System.out.println(pageUsers);
        // 3. 绑定数据
        request.setAttribute("pageUsers", pageUsers);
        // 查询条件存入request
        request.setAttribute("condition", condition);
        // 4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
