package work.ccpw.day06.demo11;

/**
 * @program: Entry
 * @description: String01
 * @author: cone
 * @create: 2020-06-02 17:15
 * 字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。
 *
 * 对于基本类型来说，==是进行数值的比较。
 * 对于引用类型来说，==是进行【地址值】的比较。
 **/
public class Demo02StringPool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        // true
        System.out.println(str1 == str2);
        // false
        System.out.println(str1 == str3);
        // false
        System.out.println(str2 == str3);
    }
}
