package work.ccpw.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.ccpw.domain.User;
import work.ccpw.mapper.UserMapper;
import work.ccpw.mapper.impl.UserMapperImpl;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 14:52
 **/
public class UserServiceTest {

    public static void main(String[] args) throws IOException {
//        // 创建dao层对象
//        UserMapper userMapper = new UserMapperImpl();
//        List<User> all = userMapper.findAll();
//        System.out.println(all);
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);

        User byId = mapper.findById(1);
        System.out.println(byId);
    }
}
