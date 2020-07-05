package work.ccpw.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: Spring
 * @description: 切面类
 * @author: cone
 * @create: 2020-07-01 19:45
 **/
@Component("myAspect")
@Aspect // 标注当前MyAspect是一个切面类
public class MyAspect {
    @Before("execution(*  work.ccpw.aop.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }
    @After("execution(*  work.ccpw.aop.*.*(..))")
    public void afterReturning(){
        System.out.println("后置增强...");
    }

    /**
     * Proceeding JoinPoint  :正在执行的连接点 === 切点
     * @param pip
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pip) throws Throwable {
        System.out.println("环绕前增强...");
        // 切点方法
        Object proceed = pip.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }
    @AfterThrowing("execution(*  work.ccpw.aop.*.*(..))")
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }
    @After("MyAspect.pointcut()")
    public void after(){
        System.out.println("最终增强...");
    }

    /**
     * 抽取切点表达式
     */
    @Pointcut("execution(*  work.ccpw.aop.*.*(..))")
    public void pointcut(){}
}
