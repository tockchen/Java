package work.ccpw.ssm.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import work.ccpw.ssm.pojo.Item;
import work.ccpw.ssm.service.ItemService;

/**
 * @program: mavenProjects
 * @description:
 * @author: Andy
 * @create: 2020-07-09 16:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class SpringMybatisTest {

    @Autowired
    public ItemService itemService;
    @Test
    public void test1(){
        Item byId = itemService.findById(1);

        System.out.println(byId);
    }
}
