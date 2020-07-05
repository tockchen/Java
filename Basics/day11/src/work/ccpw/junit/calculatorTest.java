package work.ccpw.junit;

/**
 * @program: Entry
 * @description: 测试
 * @author: cone
 * @create: 2020-06-12 14:20
 **/
public class calculatorTest {


    public static void main(String[] args) {
        // 创建对象
        Calculator  c = new Calculator();
        // 调用
        int result = c.add(1,2);
        System.out.println(result);
        int result1 = c.sub(1,2);
        System.out.println(result1);
    }
}
