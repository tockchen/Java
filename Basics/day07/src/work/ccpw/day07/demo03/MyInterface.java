package work.ccpw.day07.demo03;

/**
 * @program: Entry
 * @description: 接口可以继承多个接口
 * @author: cone
 * @create: 2020-06-03 11:52
 **/
public interface MyInterface extends MyInterfaceA,MyInterfaceB {
    public abstract void method();

    @Override
    public default void methodDefault() {

    }
}
