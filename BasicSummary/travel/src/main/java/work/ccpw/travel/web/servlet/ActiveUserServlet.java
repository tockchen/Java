package work.ccpw.travel.web.servlet;

import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.UserService;
import work.ccpw.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 11:19
 **/
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取验证码
        String code = request.getParameter("code");
        System.out.println(code);
        if (code != null) {
            UserService service = new UserServiceImpl();
            boolean  flag = service.active(code);
            System.out.println(flag);
            // 3. 判断标记
            String msg = null;
            if (flag){
                // 激活成功
                msg = "激活成功,请<a href='login.html'>登录</a>";
            }else {
                // 激活失败
                msg = "激活失败,请联系管理员!";
            }
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write(msg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
