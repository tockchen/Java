package work.ccpw.day10.demo22.StaticMethodReference;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 21:08
 **/
@FunctionalInterface
public interface Calcable {
    //定义一个抽象方法,传递一个整数,对整数进行绝对值计算并返回
    int calsAbs(int number);
}
