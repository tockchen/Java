package work.ccpw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import work.ccpw.domain.User;
import work.ccpw.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 15:36
 **/
public class MapperTest {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 模拟条件
        User condition = new User();
//        condition.setId(2);
        condition.setUsername("root");
//        condition.setPassword("root");
        List<User> byCondition = mapper.findByCondition(condition);
        System.out.println(byCondition);
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 模拟ids的数据
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> byIds = mapper.findByIds(ids);
        System.out.println(byIds);
    }
}
