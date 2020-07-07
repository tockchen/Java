package work.ccpw.service;

import work.ccpw.domain.Account;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Andy
 * @create: 2020-07-07 15:52
 **/
public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}
