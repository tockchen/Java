package work.ccpw.day07.demo15;

import work.ccpw.day07.red.RedPacketFrame;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 13:51
 **/
public class MyRed  extends RedPacketFrame {
    /**
     * 构造方法：生成红包界面。
     *
     * @param title 界面的标题
     */
    public MyRed(String title) {
        super(title);
    }
}
