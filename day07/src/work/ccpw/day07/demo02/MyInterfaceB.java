package work.ccpw.day07.demo02;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 11:48
 **/
public interface MyInterfaceB {
    // 错误写法！接口不能有静态代码块
//    static {
//
//    }

    // 错误写法！接口不能有构造方法
//    public MyInterfaceA() {
//
//    }

    public abstract void methodB();

    public abstract void methodAbs();

    public default void methodDefault() {
        System.out.println("默认方法BBB");
    }
}
