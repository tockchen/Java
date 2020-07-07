package work.ccpw.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import work.ccpw.domain.User;
import work.ccpw.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 16:50
 **/
public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 模拟user
        User user = new User();
        user.setUsername("测试");
        user.setPassword("123");
        user.setBirthday(new Date());
        // 执行保存操作
        mapper.save(user);
        sqlSession.close();
    }
    @Test
    public void testFind() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询操作
        User byId = mapper.findById(11);
        System.out.println(byId.getBirthday());
        sqlSession.close();
    }
    @Test
    public void testFindAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 设置分页的相关参数 当前页和每页显示的条数
        PageHelper.startPage(1,3);
        // 执行查询操作
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页:" +pageInfo.getPageNum());
        System.out.println("每页显示条目:"+pageInfo.getPageSize());
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("是否是第一个:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最好一页:"+pageInfo.isIsLastPage());


        sqlSession.close();
    }
}
