package work.ccpw.day06.demo24;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:17
 **/
public class Zi extends Fu {

    int num = 20;

    @Override
    public void method() {
        super.method(); // 调用了父类方法
        System.out.println("子类方法");
    }

    public void show() {
        int num = 30;
        System.out.println(num); // 30
        System.out.println(this.num); // 20
        System.out.println(super.num); // 10
    }
}
