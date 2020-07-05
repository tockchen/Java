package work.ccpw.day07.demo03;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 11:51
 **/
public interface MyInterfaceA {
    public abstract void methodA();

    public abstract void methodCommon();

    public default void methodDefault() {
        System.out.println("AAA");
    }

}
