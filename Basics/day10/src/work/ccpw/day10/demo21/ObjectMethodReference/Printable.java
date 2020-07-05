package work.ccpw.day10.demo21.ObjectMethodReference;

/**
 * @program: Entry
 * @description: 定义一个打印的函数式接口
 * @author: cone
 * @create: 2020-06-09 21:06
 **/
@FunctionalInterface
public interface Printable {
    //定义字符串的抽象方法
    void print(String s);
}
