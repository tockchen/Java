/**
 * 赋值运算符分为:
 * 基本赋值运算符: 就是一个等号"=",代表将右侧的数据交给左侧的变量.
 * int a = 30;
 * 
 * 复合赋值运算符:
 * 
 *  +=  a += 1 相当于  a = a + 1
 *  -=  b -= 2 相当于  b = b - 2
 *  *=  c -= 3 相当于  c = c * 3
 *  /=  d /= 4 相当于  d = d / 4
 *  %=  e %= 5 相当于  e = e % 5
 * 
 * 注意事项:
 *  1. 只有变量才能使用赋值运算符,常量不能进行赋值
 *  2. 复合赋值运算符其中隐含了一个强制类型转换
 */
public class Demo01Operator{
    public static void main(String[] args) {
        int a = 10;
        // 按公式进行翻译:a = a + 5
        a += 5; 
        System.out.println(a);

        int x = 10;
        x %= 3;
        System.out.println(x);

        byte num = 30;
        // num = int + int
        num += 5;
        System.out.println(num);
    }
}