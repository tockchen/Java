package work.ccpw.day06.demo16;

/**
 * @program: Entry
 * @description: 父类
 * @author: cone
 * @create: 2020-06-02 19:04
 **/
public class Fu {
    int numFu = 10;

    int num = 100;

    public void methodFu() {
        // 使用的是本类当中的，不会向下找子类的
        System.out.println(num);
    }
}
