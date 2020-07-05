package work.ccpw.day07.demo07;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 12:10
 * 鼠标就是一个USB设备
 **/
public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void click() {
        System.out.println("鼠标点击");
    }
}
