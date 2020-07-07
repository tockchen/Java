package work.ccpw.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
 * @create: 2020-07-06 21:52
 **/
public class MybatisTest {
    /**
     * 查询这个订单属于谁
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> userList = mapper.findAll();
        for (Order order : userList) {
            System.out.println(order);
        }
    }

    /**
     * 查询一个用户有那些订单
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findAll();
        for (User order : userList) {
            System.out.println(order);
        }
    }
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findUserAndRoleAll();
        for (User order : userList) {
            System.out.println(order);
        }
    }
}
