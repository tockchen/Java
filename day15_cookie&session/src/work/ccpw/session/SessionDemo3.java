package work.ccpw.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-23 14:10
 **/
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取session对象
        HttpSession session = request.getSession();
        // 2.期望客户端关闭后,session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);

        System.out.println(session);
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
