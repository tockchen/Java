package work.ccpw.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @program: Entry
 * @description: Generic初探
 * @author: cone
 * @create: 2020-06-21 16:39
 **/
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet来了....");
    }
}
