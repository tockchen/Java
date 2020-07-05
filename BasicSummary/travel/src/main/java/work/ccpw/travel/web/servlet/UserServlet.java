package work.ccpw.travel.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import work.ccpw.travel.domain.ResultInfo;
import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.UserService;
import work.ccpw.travel.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 15:42
 **/
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    // 调用service查询
    /**
     * 声明UserService业务对象
     */
    private UserService userService = new UserServiceImpl();

    /**
     * 注册功能
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 验证码校验
        String check = request.getParameter("check");
        // 从session获取验证码
        HttpSession session = request.getSession();

        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        // 为了保证验证码只使用一次
        session.removeAttribute("CHECKCODE_SERVER");

        // 比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误!");
            // 将info对象序列号为json
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(info);
            String json = writeValueAsString(info);

            response.setContentType("application/json;charset=utf8");
            response.getWriter().write(json);
            return;
        }
        // 1. 获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 2. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3. 调用service完成注册
        // UserService userService = new UserServiceImpl();
        boolean flag = userService.reqist(user);

        ResultInfo info = new ResultInfo();
        // 4. 响应结果
        if (flag) {
            // 注册成功
            info.setFlag(true);
        } else {
            // 注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }
        // 5.将info对象序列号为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(info);
        String json = writeValueAsString(info);


        // 6.将json数据写回客户端
        // 设置content-type
        response.setContentType("application/json;charset=utf8");
        response.getWriter().write(json);
    }

    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            request.getSession().setAttribute("user", u);
            info.setFlag(true);
        }

        // 7.响应数据
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf8");
//        mapper.writeValue(response.getOutputStream(), info);
        writeValue(info, response);
    }

    /**
     * 查询单个对象
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        // 将user写回客户端
        writeValue(user, response);
    }

    /**
     * 退出功能
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.销毁session
        request.getSession().invalidate();
        // 2.跳转登录页面
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    /**
     * 激活功能
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.获取验证码
        String code = request.getParameter("code");
        System.out.println(code);
        if (code != null) {
            // UserService service = new UserServiceImpl();
            boolean flag = userService.active(code);

            // 3. 判断标记
            String msg = null;
            if (flag) {
                // 激活成功
                msg = "激活成功,请<a href='login.html'>登录</a>";
            } else {
                // 激活失败
                msg = "激活失败,请联系管理员!";
            }
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write(msg);
        }
    }
}
