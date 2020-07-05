package work.ccpw.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import work.ccpw.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @program: Spring_test
 * @description: 自定义异常处理机制
 * @author: Andy
 * @create: 2020-07-05 13:40
 **/
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex  异常对象
     * @return 跳转的错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if (ex instanceof ClassCastException){
            modelAndView.addObject("info","类转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
