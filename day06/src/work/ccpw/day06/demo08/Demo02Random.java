package work.ccpw.day06.demo08;

import java.util.Random;

/**
 * @program: Entry
 * @description: 循环随机
 * @author: cone
 * @create: 2020-06-02 16:09
 **/
public class Demo02Random {
    public static void main(String[] args) {
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(10); // 范围实际上是0~9
            System.out.println(num);
        }
    }
}
