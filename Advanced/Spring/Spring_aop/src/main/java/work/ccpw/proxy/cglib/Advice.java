package work.ccpw.proxy.cglib;

/**
 * @program: Spring
 * @description: 增强
 * @author: cone
 * @create: 2020-07-01 15:45
 **/
public class Advice {
    public void before(){
        System.out.println("前置增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
}
