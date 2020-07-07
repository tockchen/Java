package work.ccpw.mapper.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.ccpw.domain.User;
import work.ccpw.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 14:47
 **/
public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        return userList;
    }

    @Override
    public User findById(int id) throws IOException {
        return null;
    }
}
