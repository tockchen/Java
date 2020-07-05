package work.ccpw.proxy.jdk;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 15:44
 **/
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
