package work.ccpw.service.impl;


import work.ccpw.dao.AccountDao;
import work.ccpw.service.AccountService;


/**
 * @author Andy
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        // 开启事务
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }

}
