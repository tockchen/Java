package work.ccpw.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.ccpw.domain.Account;
import work.ccpw.mapper.AccountMapper;
import work.ccpw.service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Andy
 * @create: 2020-07-07 15:53
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = build.openSession(true);
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//
//            mapper.save(account);
//            sqlSession.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = build.openSession(true);
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            List<Account> accountList = mapper.findAll();
//            sqlSession.close();
//            return accountList;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
        return accountMapper.findAll();
    }
}
