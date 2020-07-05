package work.ccpw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-22 13:13
 **/
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
//        response.setCharacterEncoding("GBK");

//        // 告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//        response.setHeader("content-type","text/html;charset=utf-8");

        // 简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");
        // 1. 获取字符输入流
        PrintWriter pw = response.getWriter();

        // 2. 输出数据
        pw.print("<h1>Hello response</h1><br>");
        pw.print("你好 response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
