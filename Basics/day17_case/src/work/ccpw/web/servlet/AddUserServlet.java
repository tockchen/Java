package work.ccpw.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;
import work.ccpw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-24 18:26
 **/
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf8");
        // 2.获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 3.封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 4.调用service
        UserService userService = new UserServiceImpl();
        userService.addUser(user);

        // 5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
