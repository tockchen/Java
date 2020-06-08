package work.ccpw.day08.demo06.ThreadSafe;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-08 15:33
 * 模拟卖票案例
 * 创建3个线程,同时开启,对共享的票进行出售
 **/
public class Demo01Ticket {
    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();
        // 创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        // 调用start方法开启多线程
        t1.start();
        t0.start();
        t2.start();
    }
}
