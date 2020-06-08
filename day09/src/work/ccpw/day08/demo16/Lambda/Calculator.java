package work.ccpw.day08.demo16.Lambda;

/**
 * @program: Entry
 * @description: 给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
 * @author: cone
 * @create: 2020-06-08 18:04
 **/
public interface Calculator {
    //定义一个计算两个int整数和的方法并返回结果
    public abstract int calc(int a,int b);
}
