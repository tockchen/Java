package work.ccpw.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: travel
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-29 15:44
 **/

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BaseServlet被访问了");
        // 完成方法的分发
        // 1. 获取请求路径  /travel/user/add
        String uri = req.getRequestURI();
        System.out.println("请求uri:" + uri);
        // 2. 获取方法名称 add
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println(methodName);
        // 3. 获取方法对象method
        // 谁调用我?我代表谁     UserServlet对象

        try {
            // 忽略访问权限修饰符,获取方法
            // Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 4. 执行方法
            // 暴力反射
           // method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 直接将传入的对象序列化为json,并且写回客户端
     * @param obj
     * @param response
     */
    public void writeValue(Object obj,HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf8");
        mapper.writeValue(response.getOutputStream(),obj);
    }

    /**
     * 将传入的对象序列化为json,并返回
     * @param obj 传入的对象
     * @return
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
