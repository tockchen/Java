package work.ccpw.day06.demo02;

/**
 * @program: Entry
 * @description: 对象作为方法的返回值类型
 * @author: cone
 * @create: 2020-06-02 14:14
 **/
public class Demo05PhoneReturn {
    public static void main(String[] args) {
        Phone two = getPhone();
        System.out.println(two.brand); // 苹果
        System.out.println(two.price); // 8388.0
        System.out.println(two.color); // 玫瑰金
    }

    public static Phone getPhone() {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "玫瑰金";
        return one;
    }

}
