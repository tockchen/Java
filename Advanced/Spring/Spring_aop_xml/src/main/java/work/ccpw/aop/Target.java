package work.ccpw.aop;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 17:56
 **/
public class Target implements TargetInterface{

    @Override
    public void save() {

        System.out.println("save running....");
//        int i = 1 / 0 ;
    }
}
