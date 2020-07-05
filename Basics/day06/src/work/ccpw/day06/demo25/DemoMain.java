package work.ccpw.day06.demo25;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:20
 **/
public class DemoMain {
    public static void main(String[] args) {
//        Animal animal = new Animal(); // 错误写法！不能直接创建抽象类对象

        Cat cat = new Cat();
        cat.eat();
    }

}
