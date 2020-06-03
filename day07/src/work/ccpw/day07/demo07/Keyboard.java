package work.ccpw.day07.demo07;

/**
 * @program: Entry
 * @description: 键盘
 * @author: cone
 * @create: 2020-06-03 12:10
 **/
public class Keyboard implements USB {
    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void type() {
        System.out.println("键盘输入");
    }
}
