package work.ccpw.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work.ccpw.UserDao;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-06-30 23:08
 **/
public class SpringTest {

    /**
     * 测试Scope属性 单例 默认
     */
    @Test
    public void testScope() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        // 地址一样
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    /**
     * 测试prototype属性 多例
     */
    @Test
    public void testPrototype() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        // 地址不一样
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    /**
     * 测试初始化和销毁 ,生命周期
     */
    @Test
    public void testInitAndDestroy() {
        ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        app.registerShutdownHook();
    }

    /**
     * 测试静态工厂方式
     */
    @Test
    public void testStaticFactory() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
    }
    /**
     * 测试实例工厂方式
     */
    @Test
    public void testDynamicFactory() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);

    }
}
