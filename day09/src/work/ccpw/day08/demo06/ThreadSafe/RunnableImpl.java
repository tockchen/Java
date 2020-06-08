package work.ccpw.day08.demo06.ThreadSafe;

/**
 * @program: Entry
 * @description: 实现卖票案例
 * @author: cone
 * @create: 2020-06-08 15:29
 **/
public class RunnableImpl implements Runnable{
    //定义一个多个线程共享的票源
    private  int ticket = 100;
    //设置线程任务:卖票

    /**
     *  设置线程任务:卖票
     */
    @Override
    public void run() {

        // 使用死循环,让卖票操作重复执行
        while (true){
            // 先判断票是否存在
            if (ticket > 0){
                try {
                    // 提高安全问题出现的概率,让程序睡眠
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 票存在,卖票 ticket--
                System.out.println(Thread.currentThread().getName() + "--->" + "正在卖第" + ticket);
                ticket--;
            }

        }
    }
}
