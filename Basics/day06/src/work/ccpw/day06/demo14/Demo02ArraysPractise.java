package work.ccpw.day06.demo14;

import java.util.Arrays;

/**
 * @program: Entry
 * @description: 题目： 请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
 * @author: cone
 * @create: 2020-06-02 17:54
 **/
public class Demo02ArraysPractise {
    public static void main(String[] args) {
        String str = "asv76agfqwdfvasdfvjh";

        // 如何进行升序排列：sort
        // 必须是一个数组，才能用Arrays.sort方法
        // String --> 数组，用toCharArray
        char[] chars = str.toCharArray();
        // 对字符数组进行升序排列
        Arrays.sort(chars);

        // 需要倒序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }
}
