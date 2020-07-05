package work.ccpw.listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-02 16:36
 **/
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 读取web.xml中的全局参数
        ServletContext servletContext = sce.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextConfigLocation);
        // 将spring的应用上下文对象存储到ServletContext域中

        servletContext.setAttribute("app",applicationContext);
        System.out.println("spring 容器创建完毕...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
