package work.ccpw.day08.demo02.setName;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-08 15:21
 **/
public class Demo01SetThreadName {
    public static void main(String[] args) {
        //开启多线程
        MyThread mt = new MyThread();
        mt.setName("小强");
        mt.start();

        //开启多线程
        new MyThread("旺财").start();
    }
}
