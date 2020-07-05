package work.ccpw.day06.demo27;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:27
 **/
public class DemoMain {
    public static void main(String[] args) {
//        Animal animal = new Animal(); // 错误！

//        Dog dog = new Dog(); // 错误，这也是抽象类
        // 这是普通类，可以直接new对象。
        Dog2Ha ha = new Dog2Ha();
        ha.eat();
        ha.sleep();
        System.out.println("==========");

        DogGolden golden = new DogGolden();
        golden.eat();
        golden.sleep();
    }

}
