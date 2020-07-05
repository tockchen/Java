package work.ccpw.day06.demo26;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-02 19:24
 **/
public class Zi extends Fu {

    public Zi() {
        // super();
        System.out.println("子类构造方法执行");
    }

    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }
}
