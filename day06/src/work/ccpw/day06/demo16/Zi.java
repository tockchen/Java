package work.ccpw.day06.demo16;

/**
 * @program: Entry
 * @description: 子类
 * @author: cone
 * @create: 2020-06-02 19:04
 **/
public class Zi extends Fu {
    int numZi = 20;

    int num = 200;

    public void methodZi() {
        // 因为本类当中有num，所以这里用的是本类的num
        System.out.println(num);
    }
}
