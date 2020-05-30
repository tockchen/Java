/**
 * 运算符: 进行特定操作的符号.例如:+
 * 表达式: 用运算符连起来的式子叫做表达式.例如: 20 + 5.又例如: a + b
 * 
 * 四则运算:
 * 加: +
 * 减: -
 * 乘: *
 * 除: /
 * 取模(取余数): % 
 * 首先计算得到表达式的结果.然后再打印输出这个结果.
 * 注意事项:
 *  1. 一旦运算当中有不同类型的数据,那么结果将会是数据类型范围大的那种
 */
public class Demo02Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b) );
        System.out.println("a - b = " + (a - b) );
        System.out.println("a * b = " + (a * b) );
        System.out.println("b / a = " + (b / a) );
        System.out.println("b % a = " + (b % a) );
        System.out.println("c % a = " + (c % a) );
       
    }
}