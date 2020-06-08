package work.ccpw.Thread.demo02;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-07 17:04
 **/
// 1.创建一个Thread类的子类
public class MyThread extends Thread{
    // 2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(开启线程要做什么?)
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println("run:"+i);
        }
    }
}
