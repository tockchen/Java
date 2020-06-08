package work.ccpw.day08.demo04.Runnable;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-08 15:25
 **/
public class RunnableImpl2 implements Runnable{
    //2.在实现类中重写Runnable接口的run方法,设置线程任务
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println("HelloWorld"+i);
        }
    }
}
