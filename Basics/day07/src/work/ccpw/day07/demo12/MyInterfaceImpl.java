package work.ccpw.day07.demo12;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 13:36
 **/
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void method1() {
        System.out.println("实现类覆盖重写了方法！111");
    }

    @Override
    public void method2() {
        System.out.println("实现类覆盖重写了方法！222");
    }
}
