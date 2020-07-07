package work.ccpw.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import work.ccpw.domain.User;
import work.ccpw.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 23:17
 **/
public class MyBatisTest {
    private UserMapper mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");
        mapper.save(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(2);
        user.setUsername("lucy");
        user.setPassword("234");
        mapper.update(user);
    }
    @Test
    public void testDel(){

        mapper.delete(4);
    }
    @Test
    public void testFindById(){

        User byId = mapper.findById(2);
        System.out.println(byId);
    }
    @Test
    public void testFindAll(){

        List<User> userList = mapper.findAll();

        System.out.println(userList);
    }





}
