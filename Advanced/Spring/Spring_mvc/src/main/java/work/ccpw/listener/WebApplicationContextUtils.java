package work.ccpw.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-02 16:49
 **/
public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");

    }
}
