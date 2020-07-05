package work.ccpw.interceptorl;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-03 17:45
 **/
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle running...");
        String param = request.getParameter("param");

        if ("yes".equals(param)){
            return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
//        // 返回true代表放行,返回false代表不放行
//        return true;
    }

    /**
     * 目标方法执行之后 视图返回之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("username","AD");
        System.out.println("postHandle running...");
    }

    /**
     * 在整个流程都执行完毕后 执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after running...");
    }
}
