package work.ccpw.day07.demo07;

/**
 * @program: Entry
 * @description: 电脑类
 * @author: cone
 * @create: 2020-06-03 12:11
 **/
public class Computer {
    public void powerOn() {
        System.out.println("笔记本电脑开机");
    }

    public void powerOff() {
        System.out.println("笔记本电脑关机");
    }

    /**
     * 使用USB设备的方法，使用接口作为方法的参数
     * @param usb USB
     */
    public void useDevice(USB usb) {
        usb.open(); // 打开设备
        // 一定要先判断
        if (usb instanceof Mouse) {
            // 向下转型
            Mouse mouse = (Mouse) usb;
            mouse.click();
            // 先判断
        } else if (usb instanceof Keyboard) {
            // 向下转型
            Keyboard keyboard = (Keyboard) usb;
            keyboard.type();
        }
        usb.close(); // 关闭设备
    }
}
