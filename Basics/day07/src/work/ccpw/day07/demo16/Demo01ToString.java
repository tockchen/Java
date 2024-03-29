package work.ccpw.day07.demo16;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 14:29
 *
 * java.lang.Object
 *     类 Object 是类层次结构的根(父)类。
 *     每个类(Person,Student...)都使用 Object 作为超(父)类。
 *     所有对象（包括数组）都实现这个类的方法。
 **/
public class Demo01ToString {
    public static void main(String[] args) {
        /*
            Person类默认继承了Object类,所以可以使用Object类中的toString方法
            String toString() 返回该对象的字符串表示。
         */
        Person p = new Person("张三",18);
        String s = p.toString();
        //com.itheima.demo01.Object.Person@75412c2f | abc | Person{name=张三 ,age=18}
        System.out.println(s);
        //直接打印对象的名字,其实就是调用对象的toString  p=p.toString();
        //com.itheima.demo01.Object.Person@5f150435 | abc | Person{name=张三 ,age=18}
        System.out.println(p);
        //看一个类是否重写了toString,直接打印这个类的对象即可,如果没有重写toString方法那么打印的是对象的地址值
        Random r = new Random();
        //java.util.Random@3f3afe78  没有重写toString方法
        System.out.println(r);
        Scanner sc = new Scanner(System.in);
        //java.util.Scanner[delimiters=\p{javaWhitespace}+..  重写toString方法
        System.out.println(sc);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //[1, 2, 3]  重写toString方法
        System.out.println(list);
    }
}
