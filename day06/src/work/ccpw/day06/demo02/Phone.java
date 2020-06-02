package work.ccpw.day06.demo02;

/**
 * @program: Entry
 * @description: 手机类
 * @author: cone
 * @create: 2020-06-02 13:53
 * 定义一个类，用来模拟“手机”事物。
 * 属性：品牌、价格、颜色
 * 行为：打电话、发短信
 *
 * 对应到类当中：
 * 成员变量（属性）：
 *     String brand; // 品牌
 *     double price; // 价格
 *     String color; // 颜色
 * 成员方法（行为）：
 *     public void call(String who) {} // 打电话
 *     public void sendMessage() {} // 群发短信
 **/
public class Phone {
    // 成员变量
    /**
     * 品牌
     */
    String brand;
    /**
     * 价格
     */
    double price;
    /**
     * 颜色
     */
    String color;

    /**
     * 成员方法
     * @param who
     */
    public void call(String who) {
        System.out.println("给" + who + "打电话");
    }

    public void sendMessage() {
        System.out.println("群发短信");
    }
}
