package work.ccpw.day07.demo02;

/**
 * @program: Entry
 * @description: 接口
 * @author: cone
 * @create: 2020-06-03 11:45
 **/
public interface MyInterface {
    public default void method() {
        System.out.println("接口的默认方法");
    }
}
