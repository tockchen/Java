package work.ccpw.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-27 21:06
 **/
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的格式为json和编码为utf8
        response.setContentType("application/json;charset=utf8");
        // 1.获取用户名
        String username = request.getParameter("username");
        HashMap<String , Object> map = new HashMap<>();
        // 2. 调用service层判断用户名是否存在
        if ("tom".equals(username)){
            // 存在
            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎,请更换一个");
        }else {
            // 不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }
        // 将map转为json,并且传递给客户端
        // 将map转为json
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
