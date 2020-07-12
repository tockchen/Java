package work.ccpw.ssm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import work.ccpw.ssm.dao.ItemMapper;
import work.ccpw.ssm.pojo.Item;


/**
 * @program: mavenProjects
 * @description:
 * @author: Andy
 * @create: 2020-07-09 16:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class SpringMybatisTest {

    @Autowired
    public ItemMapper itemMapper;
    @Test
    public void test1(){
        Item byId = itemMapper.findById(1);

        System.out.println(byId);
    }
}
