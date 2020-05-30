public class Demo02Variable {
    public static void main(String[] args) {
        // 创建一个变量
        // 格式: 数据类型 变量名称;
        int num1;
        // 向变量当中存入一个数据
        // 格式: 变量名称 = 数据值
        num1 = 10;
        // 当打印输出变量名称的时候,显示出来的是变量的内容
        System.out.println(num1); // 10

        // 改变变量本来的内容
        num1 = 20;
        System.out.println(num1); // 20

        // 使用一步到位的格式定义变量
        // 格式: 数据类型 变量名称 = 数据值
        int num2 = 25;
        System.out.println(num2);// 25
        num2 = 35;
        System.out.println(num2);// 35
        System.out.println("===============");

        byte num3 = 30; // 注意: 右侧数值的范围不能超过左侧数据类型的取值范围
        System.out.println(num3);// 30

        short num4 = 50;
        System.out.println(num4);// 50

        long num5 = 3000000000L;
        System.out.println(num5);// 3000000000

        float num6 = 2.5F;
        System.out.println(num6);// 2.5
        
        double num7 = 1.8;
        System.out.println(num7);// 1.8

        char char1 = 'A';
        System.out.println(char1);// A

        char1 = '中';
        System.out.println(char1);// 中

        boolean var1 = true;
        System.out.println(var1);// true
        var1 = false;
        System.out.println(var1);// false

        // 将一个变量的数据内容,赋值交给另一个变量
        // 右侧的变量内容var1已经存在,里面装的是false布尔值
        // 将右侧变量里面的false值,向左交给var2
        boolean var2 = var1;
        System.out.println(var2);// false
    }
}