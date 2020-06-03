package work.ccpw.day07.demo01;

/**
 * @program: Entry
 * @description: 接口--私有方法实现
 * @author: cone
 * @create: 2020-06-03 11:36
 **/
public class MyInterfacePrivateAImpl implements MyInterfacePrivateA {
    public void methodAnother() {
        // 直接访问到了接口中的默认方法，这样是错误的！
//        methodCommon();
    }
}
