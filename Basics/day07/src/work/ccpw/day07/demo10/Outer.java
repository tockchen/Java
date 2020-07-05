package work.ccpw.day07.demo10;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 13:29
 **/
public class Outer {
    /**
     * 外部类的成员变量
     */
    int num = 10;

    public class Inner /*extends Object*/ {

        int num = 20; // 内部类的成员变量

        public void methodInner() {
            int num = 30; // 内部类方法的局部变量
            System.out.println(num); // 局部变量，就近原则
            System.out.println(this.num); // 内部类的成员变量
            System.out.println(Outer.this.num); // 外部类的成员变量
        }

    }
}
