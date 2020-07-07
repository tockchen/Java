package work.ccpw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import work.ccpw.domain.User;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-05 16:36
 **/
public class MyBatisTest {

    /**
     * 查询操作
     * @throws IOException
     */
    @Test
    public void testFind() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session对话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数:namespace
        List<User> useList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        System.out.println(useList);
        // 释放资源
        sqlSession.close();
    }

    /**
     * 保存操作
     * @throws IOException
     */
    @Test
    public void testSave() throws IOException {
        // 模拟user对象
        User user = new User();
        user.setUsername("tosmfgsd");
        user.setPassword("tom");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session对话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 执行操作 参数:namespace
        sqlSession.insert("userMapper.save",user);
        // mybatis执行更新操作,提交事务,mybatis默认不提交
//        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    /**
     * 更新操作
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        // 模拟user对象
        User user = new User();
        user.setId(7);
        user.setUsername("make");
        user.setPassword("123");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session对话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数:namespace
        sqlSession.update("userMapper.update",user);
        // mybatis执行更新操作,提交事务,mybatis默认不提交
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
    /**
     * 删除操作
     * @throws IOException
     */
    @Test
    public void testDel() throws IOException {

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session对话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数:namespace
        sqlSession.update("userMapper.delete",6);
        // mybatis执行更新操作,提交事务,mybatis默认不提交
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
    @Test
    public void testById() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session对话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数:namespace
        User user = sqlSession.selectOne("userMapper.findById", 1);
        // 打印数据
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }
}
