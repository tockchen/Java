package work.ccpw.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: Spring
 * @description: 切面类 增强
 * @author: cone
 * @create: 2020-07-01 17:57
 **/
public class MyAspect {

    public void before(){
        System.out.println("前置增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }

    /**
     * Proceeding JoinPoint  :正在执行的连接点 === 切点
     * @param pip
     */
    public Object around(ProceedingJoinPoint pip) throws Throwable {
        System.out.println("环绕前增强...");
        // 切点方法
        Object proceed = pip.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }
    public void after(){
        System.out.println("最终增强...");
    }
}
