package work.ccpw.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import work.ccpw.dao.AccountDao;
import work.ccpw.service.AccountService;


/**
 * @author Andy
 */
@Service("accountService")
@Transactional(isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        // 开启事务
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NEVER)
    public void findAll(){

    }

}
