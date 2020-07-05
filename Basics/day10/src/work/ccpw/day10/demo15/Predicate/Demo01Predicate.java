package work.ccpw.day10.demo15.Predicate;

import java.util.function.Predicate;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 18:06
 *
 * java.util.function.Predicate<T>接口
 *  作用:对某种数据类型的数据进行判断,结果返回一个boolean值
 *
 *  Predicate接口中包含一个抽象方法：
 *      boolean test(T t):用来对指定数据类型数据进行判断的方法
 *          结果:
 *              符合条件,返回true
 *              不符合条件,返回false
 **/
public class Demo01Predicate {

    /**
     *
     * @param s  传递一个String类型的字符串
     * @param pre  一个Predicate接口,泛型使用String
     * @return  使用Predicate中的方法test对字符串进行判断,并把判断的结果返回
     */
    public static boolean checkString(String s, Predicate<String> pre){
        return  pre.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abcdef";

        //调用checkString方法对字符串进行校验,参数传递字符串和Lambda表达式
        /*boolean b = checkString(s,(String str)->{
            //对参数传递的字符串进行判断,判断字符串的长度是否大于5,并把判断的结果返回
            return str.length()>5;
        });*/

        //优化Lambda表达式
        boolean b = checkString(s,str->str.length()>5);
        System.out.println(b);
    }
}
