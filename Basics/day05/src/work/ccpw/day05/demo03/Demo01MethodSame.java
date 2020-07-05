package work.ccpw.day05.demo03;

/**
 * @program: Entry
 * @description: 题目要求： 定义一个方法，用来判断两个数字是否相同。
 * @author: cone
 * @create: 2020-05-30 16:19
 **/
public class Demo01MethodSame {
    public static void main(String[] args) {
        // false
        System.out.println(isSame(10, 20));
        // true
        System.out.println(isSame(20, 20));
    }

    /**
     * 三要素：
     *     返回值类型：boolean
     *     方法名称：isSame
     *     参数列表：int a, int b
     */
    public static boolean isSame(int a, int b) {
        /*boolean same;
        if (a == b) {
            same = true;
        } else {
            same = false;
        }*/

        // boolean same = a == b ? true : false;

        // boolean same = a == b;

        return a == b;
    }

}
