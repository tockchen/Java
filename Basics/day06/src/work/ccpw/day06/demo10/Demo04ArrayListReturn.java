package work.ccpw.day06.demo10;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: Entry
 * @description: 题目： 用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合当中。 要求使用自定义的方法来实现筛选。
 * @author: cone
 * @create: 2020-06-02 16:35
 * 分析：
 * 1. 需要创建一个大集合，用来存储int数字：<Integer>
 * 2. 随机数字就用Random nextInt
 * 3. 循环20次，把随机数字放入大集合：for循环、add方法
 * 4. 定义一个方法，用来进行筛选。
 * 筛选：根据大集合，筛选符合要求的元素，得到小集合。
 * 三要素
 * 返回值类型：ArrayList小集合（里面元素个数不确定）
 * 方法名称：getSmallList
 * 参数列表：ArrayList大集合（装着20个随机数字）
 * 5. 判断（if）是偶数：num % 2 == 0
 * 6. 如果是偶数，就放到小集合当中，否则不放。
 **/
public class Demo04ArrayListReturn {
    public static void main(String[] args) {
        // 创建ArrayList 对象
        ArrayList<Integer> bigList = new ArrayList<>();
        // 创建Random 对象
        Random r = new Random();
        // 添加随机数到集合
        for (int i = 0; i < 20; i++) {
            // 1~100
            bigList.add(r.nextInt(100) + 1);
        }
        // 调用偶数集合的方法
        ArrayList<Integer> smallList = getSmallList(bigList);
        System.out.println("偶数总共有多少个：" + smallList.size());
        for (Integer smallNum : smallList) {
            System.out.println(smallNum);
        }
    }
    /**
     * 这个方法，接收大集合参数，返回小集合结果
     * @param bigList ArrayList
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList) {
        // 创建小集合,来保存偶数
        ArrayList<Integer> smallList = new ArrayList<>();
        // 遍历list,并获取元素
        for (Integer num : bigList) {
            // 判断为偶数,添加到小集合中
            if (num % 2 == 0) {
                smallList.add(num);
            }
        }
        // 返回小集合
        return smallList;
    }
}
