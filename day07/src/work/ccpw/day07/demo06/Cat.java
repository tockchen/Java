package work.ccpw.day07.demo06;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 12:02
 **/
public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    /**
     * 子类特有方法
     */
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}
