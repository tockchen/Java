package work.ccpw.day06.demo18;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:08
 **/
public class Zi extends Fu {

    public void methodZi() {
        System.out.println("子类方法执行！");
    }

    @Override
    public void method() {
        System.out.println("子类重名方法执行！");
    }
}
