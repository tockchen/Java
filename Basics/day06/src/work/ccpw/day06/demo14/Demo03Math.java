package work.ccpw.day06.demo14;

/**
 * @program: Entry
 * @description: 数学工具类
 * @author: cone
 * @create: 2020-06-02 17:57
 * java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。
 *
 * public static double abs(double num)：获取绝对值。有多种重载。
 * public static double ceil(double num)：向上取整。
 * public static double floor(double num)：向下取整。
 * public static long round(double num)：四舍五入。
 *
 * Math.PI代表近似的圆周率常量（double）。
 **/
public class Demo03Math {
    public static void main(String[] args) {
        // 获取绝对值
        // 3.14
        System.out.println(Math.abs(3.14));
        // 0
        System.out.println(Math.abs(0));
        // 2.5
        System.out.println(Math.abs(-2.5));
        System.out.println("================");

        // 向上取整
        // 4.0
        System.out.println(Math.ceil(3.9));
        // 4.0
        System.out.println(Math.ceil(3.1));
        // 3.0
        System.out.println(Math.ceil(3.0));
        System.out.println("================");

        // 向下取整，抹零
        // 30.0
        System.out.println(Math.floor(30.1));
        // 30.0
        System.out.println(Math.floor(30.9));
        // 31.0
        System.out.println(Math.floor(31.0));
        System.out.println("================");

        // 20
        System.out.println(Math.round(20.4));
        // 11
        System.out.println(Math.round(10.5));
    }
}
