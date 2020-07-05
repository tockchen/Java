package work.ccpw.web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import work.ccpw.config.SpringConfiguration;
import work.ccpw.service.UserService;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 13:25
 **/

public class UserController {
    public static void main(String[] args) {
//        ConfigurableApplicationContext  app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService service = app.getBean("userService", UserService.class);
        app.registerShutdownHook();
        service.save();

    }
}
