package work.ccpw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
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
 * @create: 2020-07-07 00:15
 **/
public class MyBatisTest3 {
    private UserMapper mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testFindUserAndOrderAll(){
        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
        for (User user : userAndOrderAll) {
            System.out.println(user);
        }
    }

}
