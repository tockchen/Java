package work.ccpw.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import work.ccpw.proxy.jdk.TargetInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 15:51
 **/
public class ProxyTest {
    private Enhancer enhancer;

    public static void main(String[] args) {
        // 创建目标对象
        Target target = new Target();
        // 获得增强对象
        Advice advice = new Advice();
        // 返回值 就是动态生成的代理对象 基于cglib
        // 1.创建增强器
        Enhancer enhancer = new Enhancer();
        // 2.设置父类(目标对象)
        enhancer.setSuperclass(Target.class);
        // 3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 1.执行前置
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.afterReturning();
                return invoke;
            }
        });
        // 4.创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
