package work.ccpw.day05.demo07;

/**
 * @program: Entry
 * @description: 获取数组长度
 * @author: cone
 * @create: 2020-05-30 21:25
 **/
public class Demo03ArrayLength {
    public static void main(String[] args) {
        int[] arrayA = new int[3];
        System.out.println(arrayA.length);
        int[] arrayB = {10, 20, 30, 3, 5, 4, 6, 7, 8, 8, 65, 4, 44, 6, 10, 3, 5, 4, 6, 7, 8, 8, 65, 4};
        int len = arrayB.length;
        System.out.println("arrayB数组的长度是：" + len);
        System.out.println("=============");

        int[] arrayC = new int[3];
        System.out.println(arrayC.length); // 3
        arrayC = new int[5];
        System.out.println(arrayC.length); // 5
    }
}
