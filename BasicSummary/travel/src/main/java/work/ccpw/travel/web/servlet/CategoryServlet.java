package work.ccpw.travel.web.servlet;

import work.ccpw.travel.domain.Category;
import work.ccpw.travel.service.CategoryService;
import work.ccpw.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 16:03
 **/
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();

    /**
     * 查询所有
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.

        // 1. 调用servlice查询所有
        List<Category> cs = categoryService.findAll();

        // 2. 序列号json返回
       writeValue(cs,response);
    }


}
