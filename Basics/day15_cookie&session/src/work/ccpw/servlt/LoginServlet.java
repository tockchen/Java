package work.ccpw.servlt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-23 14:57
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置request编码
        request.setCharacterEncoding("utf8");
        // 2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 3.先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 拿到验证码删除session中的验证码,防止验证码重复使用
        session.removeAttribute("checkCode_session");
        // 4.先判断验证码是否正确,忽略大小写比较
        if (checkCode_session !=null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 验证码正确
            // 判断用户名和密码是否一致
            if ("root".equals(username) && "root".equals(password)) {
                // 登录成功
                // 存储信息,用户信息
                session.setAttribute("username",username);
                // 重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                // 存储提示信息到request
                request.setAttribute("login_error", "用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            // 验证码不一致
            // 存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
