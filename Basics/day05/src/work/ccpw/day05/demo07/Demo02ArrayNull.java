package work.ccpw.day05.demo07;

/**
 * @program: Entry
 * @description: 空指针异常
 * @author: cone
 * @create: 2020-05-30 21:24
 **/
public class Demo02ArrayNull {
    public static void main(String[] args) {
        int[] array = null;
        // array = new int[3];
        System.out.println(array[0]);
    }
}
