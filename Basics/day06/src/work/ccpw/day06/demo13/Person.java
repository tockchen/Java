package work.ccpw.day06.demo13;

/**
 * @program: Entry
 * @description: static代码块
 * @author: cone
 * @create: 2020-06-02 17:47
 **/
public class Person {
    static {
        System.out.println("静态代码块执行！");
    }

    public Person() {
        System.out.println("构造方法执行！");
    }

}
