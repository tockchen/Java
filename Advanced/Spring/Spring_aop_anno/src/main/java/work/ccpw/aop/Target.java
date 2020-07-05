package work.ccpw.aop;

import org.springframework.stereotype.Component;

/**
 * @program: Spring
 * @description: 目标类
 * @author: cone
 * @create: 2020-07-01 19:44
 **/
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running ...");
    }
}
