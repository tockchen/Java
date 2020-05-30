package work.ccpw.day05.demo04;

/**
 * @program: Entry
 * @description: 模拟输出语句中的 println 方法效果，传递什么类型的数据就输出什么类型的数据，只允许定义一个方法名println 。
 * @author: cone
 * @create: 2020-05-30 16:38
 **/
public class Demo04OverloadPrint {
    public static void main(String[] args) {
        // int
        myPrint(100);
        // String
        myPrint("Hello");
    }

    public static void myPrint(byte num) {
        System.out.println(num);
    }

    public static void myPrint(short num) {
        System.out.println(num);
    }

    public static void myPrint(int num) {
        System.out.println(num);
    }

    public static void myPrint(long num) {
        System.out.println(num);
    }

    public static void myPrint(float num) {
        System.out.println(num);
    }

    public static void myPrint(double num) {
        System.out.println(num);
    }

    public static void myPrint(char zifu) {
        System.out.println(zifu);
    }

    public static void myPrint(boolean is) {
        System.out.println(is);
    }

    public static void myPrint(String str) {
        System.out.println(str);
    }

}
