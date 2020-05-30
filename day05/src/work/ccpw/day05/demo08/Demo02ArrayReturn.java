package work.ccpw.day05.demo08;

/**
 * @program: Entry
 * @description: 数组作为返回值类型
 * @author: cone
 * @create: 2020-05-30 21:38
 **/
public class Demo02ArrayReturn {
    public static void main(String[] args) {
        int[] result = calculate(10, 20, 30);

        System.out.println("main方法接收到的返回值数组是：");
        // 地址值
        System.out.println(result);

        System.out.println("总和：" + result[0]);
        System.out.println("平均数：" + result[1]);
    }

    public static int[] calculate(int a, int b, int c) {
        // 总和
        int sum = a + b + c;
        // 平均数
        int avg = sum / 3;
        // 两个结果都希望进行返回

        // 需要一个数组，也就是一个塑料兜，数组可以保存多个结果
        /*
        int[] array = new int[2];
        array[0] = sum; // 总和
        array[1] = avg; // 平均数
        */

        int[] array = { sum, avg };
        System.out.println("calculate方法内部数组是：");
        // 地址值
        System.out.println(array);
        return array;
    }
}
