package work.ccpw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import work.ccpw.aop.MyAspect;
import work.ccpw.aop.TargetInterface;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 19:52
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AnnoTest {
    @Autowired
    private TargetInterface targetInterface;
    @Test
    public void test1(){
        targetInterface.save();
    }
}
