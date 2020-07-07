package work.ccpw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import work.ccpw.domain.Order;
import work.ccpw.domain.User;
import work.ccpw.mapper.OrderMapper;
import work.ccpw.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 23:56
 **/
public class MyBatisTest2 {
    private OrderMapper orderMapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }
    @Test
    public void testSave(){
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
    @Test
    public void testSave2(){
        List<Order> orderList = orderMapper.findAllA();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
    @Test
    public void testSave3(){
        List<Order> orderList = orderMapper.findAllA();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
