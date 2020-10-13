package work.ccpw.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import work.ccpw.travel.domain.ResultInfo;
import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.UserService;
import work.ccpw.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 12:31
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        // 2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3.调用service查询
        UserService userService = new UserServiceImpl();
        User u = userService.login(user);
        ResultInfo info = new ResultInfo();
        // 4.判断用户对象是否为null
        if (u == null) {
            // 用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        // 5.判断用户是否激活
        if (u != null && !"Y".equals(u.getStatus())) {
            // 用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活,请激活");
        }
        // 6.判断登录成功
        if (u != null && "Y".equals(u.getStatus())) {
            // 登录成功标记
            request.getSession().setAttribute("user",u);
            info.setFlag(true);
        }

        // 7.响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}