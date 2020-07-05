package work.ccpw.day08.demo13.Lambda;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-08 17:31
 **/
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 新线程创建了");
    }
}
