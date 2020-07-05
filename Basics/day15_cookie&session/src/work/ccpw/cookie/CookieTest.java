package work.ccpw.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-23 12:28
 * ⅰ. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 *      1. 有：不是第一次访问
 *          a. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 *          b. 写回Cookie：lastTime=2018年6月10日11:50:01
 *      2. 没有：是第一次访问
 *          a. 响应数据：您好，欢迎您首次访问
 *          b. 写回Cookie：lastTime=2018年6月10日11:50:01
 **/
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息提的数据格式以及编码
        response.setContentType("text/html;charset=utf8");
        // 1. 获取所有 Cookie
        Cookie[] cookies = request.getCookies();
        // 没有cookie为lastTime
        boolean flag = false;

        // 2. 遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 3.获取cookie的名称
                String name = cookie.getName();
                // 4.判断名称是否是:lastTime
                if ("lastTime".equals(name)) {
                    // 有该Cookie,不是第一次访问
                    // 有lastTime的cookie
                    flag = true;
                    // 响应数据
                    // 获取Cookie的value,时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码：
                    value = URLDecoder.decode(value, StandardCharsets.UTF_8);
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来,您上次访问时间为:" + value + "</h1>");
                    // 设置Cookie的value
                    // 获取当前时间的字符串,重新设置Cookie的值,重新发送cookie
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(data);
                    System.out.println("编码前：" + strDate);
                    //URL编码
                    strDate = URLEncoder.encode(strDate, StandardCharsets.UTF_8);
                    System.out.println("编码后：" + strDate);
                    cookie.setValue(strDate);
                    // 设置cookie的存活时间 一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || !flag) {

            // 设置Cookie的value
            // 获取当前时间的字符串,重新设置Cookie的值,重新发送cookie
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(data);
            System.out.println("编码前：" + strDate);
            //URL编码
            strDate = URLEncoder.encode(strDate, "utf8");
            System.out.println("编码后：" + strDate);

            Cookie cookie = new Cookie("lastTime", strDate);

            // 设置cookie的存活时间 一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好,欢迎您首次访问</h1>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
