package work.ccpw.jedis.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import work.ccpw.jedis.domain.Province;
import work.ccpw.jedis.service.ProvinceService;
import work.ccpw.jedis.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-28 10:28
 **/
@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service查询
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        // 2.序列号list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println(json);
        // 3.响应结果
        response.setContentType("application/json;charset=utf8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
