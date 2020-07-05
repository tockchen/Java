/**
 * 强制类型转换
 *  1. 特点:代码需要进行特殊的格式处理,不能自动完成
 *  2. 格式:范围小的类型 范围小的变量名 = (范围小的类型)原本范围大的数据
 * 
 * 注意事项;
 *  1. 强制类型转换一般不推荐使用,因为有可能发生精度损失,数据溢出
 *  2. byte/shot/char这三种类型都可以发生数学运算,例如加法"+".
 *  3. byte/shot/char这三种类型在运算的时候,都会被首先提升成为int类型,然后再计算
 *  4. boolean类型不能发生数据类型转换
 */
public class Demo02DataType {
    public static void main(String[] args) {
        int num = (int)100L;
        System.out.println(num);// 100

        int num1 = (int)1233333233333L;// 677619381
        System.out.println(num1);
        int num2 = (int)3.9;// 3
        System.out.println(num2);// 这并不是四舍五入,所有的小数位都会被省略

        char zifu1 = 'A';
        System.out.println(zifu1 + 1); // 66,也就是大写字母A被当作65进行处理
        // 计算机的底层会使用一个数字(二进制)来表示字符A,就是65
        // 一旦char类型进行数学运算,那么字符就会按照一定的规则翻译成为一个数字

        byte num3 = 40;
        byte num4 = 50;
        // byte + byte --> int + int
        int result = num3 + num4;
        System.out.println(result);
    }
}