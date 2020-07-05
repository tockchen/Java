package work.ccpw.day07.demo03;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 11:51
 **/
public interface MyInterfaceB {
    public abstract void methodB();

    public abstract void methodCommon();

    public default void methodDefault() {
        System.out.println("BBB");
    }

}
