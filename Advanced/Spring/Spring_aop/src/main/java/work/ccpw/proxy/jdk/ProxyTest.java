package work.ccpw.proxy.jdk;

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
    public static void main(String[] args) {
        // 创建目标对象
        Target target = new Target();
        // 获得增强对象
        Advice advice = new Advice();
        // 返回值 就是动态生成的代理对象
        TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(
                // 目标对象的类加载器
                target.getClass().getClassLoader(),
                // 目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 调用代理对象的任何方法 实质执行的都是invoke
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 执行目标方法
                        // 前置增强
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        // 后置增强
                        advice.afterReturning();
                        return invoke;
                    }
                }
        );
        // 调用代理对象的方法
        proxy.save();
    }
}
