package work.ccpw.day06.demo02;

/**
 * @program: Entry
 * @description: 对象作为参数传递到方法中
 * @author: cone
 * @create: 2020-06-02 14:13
 **/
public class Demo04PhoneParam {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "土豪金";

        method(one); // 传递进去的参数其实就是地址值
    }

    public static void method(Phone param) {
        System.out.println(param.brand); // 苹果
        System.out.println(param.price); // 8388.0
        System.out.println(param.color); // 土豪金
    }

}
