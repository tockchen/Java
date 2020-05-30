/**
 * 四则运算当中的加号"+"有常见的三种用法
 * 
 * 1. 对于数值来说,那就是加法
 * 2. 对于字符char类型来说,在计算之前,char会被提升成为int,然后再计算
 * char类型字符,和int类型数字之间的对照关系表:ASCII,Unicode
 * 3. 对于字符串String(首字母大写,并不是关键字)来说,加号代表字符串连接操作
 */
public class Demo03Plus {
    public static void main(String[] args) {
        // 字符串类型的变量基本使用
        // 数据类型 变量名称 = 数据值
        String str1 = "Hello";
        System.out.println(str1);// Hello
        System.out.println(str1 + "World");// HelloWorld
        // String + int --> String
        String str2 = "Java";
        System.out.println(str2 + 20);// Java20

        

    }
}