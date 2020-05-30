package work.ccpw.day05.demo07;

/**
 * @program: Entry
 * @description: 数组遍历
 * @author: cone
 * @create: 2020-05-30 21:26
 **/
public class Demo04Array {
    public static void main(String[] args) {
        int[] array = { 15, 25, 30, 40, 50, 60, 75 };

        // 首先使用原始方式
        System.out.println(array[0]); // 15
        System.out.println(array[1]); // 25
        System.out.println(array[2]); // 30
        System.out.println(array[3]); // 40
        System.out.println(array[4]); // 50
        System.out.println(array[5]); // 50
        System.out.println("=================");

        // 使用循环，次数其实就是数组的长度。
        for (int i = 0; i < 6; i++) {
            System.out.println(array[i]);
        }
        System.out.println("=================");

        //        int len = array.length; // 长度
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
