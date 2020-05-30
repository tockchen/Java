/**
 * 一元运算符: 只需要一个数据就可以进行操作的运算符.例如:取反!,自增++,自减--
 * 二元运算符: 需要两个数据才可以进行操作的运算符.例如:加法+,减法-
 * 三元运算符: 需要三个数据才可以进行操作的运算符
 * 
 * 格式:
 * 数据类型 变量名称 = 条件判断 ? 表达式A : 表达式B
 * 
 * 流程:
 * 首先判断条件是否成立:
 *      如果成立为true,那么将表达式A的值赋值给左侧的变量
 *      否则将表达式B的值赋值给左侧的变量
 * 二者选一
 * 
 * 注意事项:
 *  1. 必须同时保证表达式A和表达式B都符合左侧数据类型的要求
 *  2. 三元运算符的结果必须被使用
 */
public class Demo04Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int max = a > b ? a : b;// 最大值的变量
        System.out.println(max);// 20
        //int result = 3 > 4 ? 2.5 : 3; 错误写法
        System.out.println(a > b ? a : b);// 20
    }
}