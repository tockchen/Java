package work.ccpw.day06.demo10;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: Entry
 * @description: 题目：生成6个1~33之间的随机整数，添加到集合，并遍历集合。
 * @author: cone
 * @create: 2020-06-02 16:21
 * 思路：
 * 1. 需要存储6个数字，创建一个集合，<Integer>
 * 2. 产生随机数，需要用到Random
 * 3. 用循环6次，来产生6个随机数字：for循环
 * 4. 循环内调用r.nextInt(int n)，参数是33，0~32，整体+1才是1~33
 * 5. 把数字添加到集合中：add
 * 6. 遍历集合：for、size、get
 **/
public class Demo01ArrayListRandom {
    public static void main(String[] args) {
        // 创建ArrayList 对象
        ArrayList<Integer> arrays = new ArrayList<>();
        // 创建Random 对象
        Random random = new Random();
        // 添加随机数到集合
        for (int i = 0;i < 6; i ++){
            arrays.add(random.nextInt(33)+1);
        }
        // 遍历集合输出
        for (Integer  array: arrays) {
            System.out.println(array);
        }
    }

}
