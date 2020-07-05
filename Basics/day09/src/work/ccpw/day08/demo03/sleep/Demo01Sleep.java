package work.ccpw.day08.demo03.sleep;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-08 15:23
 **/
public class Demo01Sleep {
    public static void main(String[] args) {
        //模拟秒表
        for (int i = 1; i <=60 ; i++) {
            System.out.println(i);

            //使用Thread类的sleep方法让程序睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
