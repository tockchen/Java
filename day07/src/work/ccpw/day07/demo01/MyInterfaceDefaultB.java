package work.ccpw.day07.demo01;

/**
 * @program: Entry
 * @description: 实现接口默认方法
 * @author: cone
 * @create: 2020-06-03 11:25
 **/
public class MyInterfaceDefaultB implements MyInterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法，BBB");
    }

    @Override
    public void methodDefault() {
        System.out.println("实现类B覆盖重写了接口的默认方法");
    }
}
