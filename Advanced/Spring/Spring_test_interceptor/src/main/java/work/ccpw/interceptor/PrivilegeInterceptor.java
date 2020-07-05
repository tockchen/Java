package work.ccpw.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import work.ccpw.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: Spring_test
 * @description:
 * @author: Andy
 * @create: 2020-07-04 21:46
 **/
public class PrivilegeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean flag = request.getRequestURI().contains("login");
        if (flag){
            return true;
        }
        // 逻辑:判断用户是否登录,本质,判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // 没有登录
            request.getRequestDispatcher("/login.jsp").forward(request,response);
//            response.sendRedirect("/login.jsp");
            return false;
        }
        // 放行,访问目标资源
        return true;
    }
}
