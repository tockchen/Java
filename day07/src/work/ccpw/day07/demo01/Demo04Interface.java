package work.ccpw.day07.demo01;

/**
 * @program: Entry
 * @description: 接口--静态方法
 * @author: cone
 * @create: 2020-06-03 11:30
 **/
public class Demo04Interface {
    public static void main(String[] args) {
        MyInterfacePrivateB.methodStatic1();
        MyInterfacePrivateB.methodStatic2();
        // 错误写法！
//        MyInterfacePrivateB.methodStaticCommon();
    }
}
