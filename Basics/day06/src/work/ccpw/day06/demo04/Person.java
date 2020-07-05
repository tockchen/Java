package work.ccpw.day06.demo04;

/**
 * @program: Entry
 * @description: this
 * @author: cone
 * @create: 2020-06-02 14:38
 * 当方法的局部变量和类的成员变量重名的时候，根据“就近原则”，优先使用局部变量。
 * 如果需要访问本类当中的成员变量，需要使用格式：
 * this.成员变量名
 *
 * “通过谁调用的方法，谁就是this。”
 **/
public class Person {
    /**
     * 我自己的名字
     */
    String name;


    /**
     * 成员变量name是自己的名字
     * @param name 对方的名字
     */
    public void sayHello(String name) {
        System.out.println(name + "，你好。我是" + this.name);
        System.out.println(this);
    }

}
