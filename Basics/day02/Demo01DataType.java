/*
当数据类型不一样时,将会发生数据类型转换

自动类型转换(隐式)
    1. 特点:代码不需要进行特殊处理,自动完成
    2. 规则:数据范围从小到大
*/ 
public class Demo01DataType{
    public static void main(String[] args) {
        System.out.println(1024);// 这是一个整数,默认是int类型
        System.out.println(3.14);// 这是一个浮点型,默认是double类型

        // 左边是long类型,右边是默认的int类型,左右不一样
        // 一个等号代表赋值,将右侧的int常量,交给左侧的long变量进行存储
        // int --> lont,符合了数据范围从小到大的要求
        // 这一行代码发生了自动类型转换
        long num1 = 100;
        System.out.println(num1); // 100
    }
}