package work.ccpw.day06.demo20;

/**
 * @program: Entry
 * @description: 定义一个新手机，使用老手机作为父类
 * @author: cone
 * @create: 2020-06-02 19:12
 **/
public class NewPhone extends Phone {
    @Override
    public void show() {
        super.show(); // 把父类的show方法拿过来重复利用
        // 自己子类再来添加更多内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
