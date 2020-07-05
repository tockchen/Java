package work.ccpw.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work.ccpw.service.UserService;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 00:07
 **/
public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 以id方式
//        UserService userService = (UserService) app.getBean("userService");
        // 字节码类型 如果配置文件中存在多个类型相同(class相同)的bean会报错不能区分,用id方式可以区分,id是唯一的
        UserService userService = app.getBean(UserService.class);
        userService.save();
//        UserService userService = new UserServiceImpl();
//        userService.save();
    }
}
