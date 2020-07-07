package work.ccpw.mapper;

import work.ccpw.domain.Account;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Andy
 * @create: 2020-07-07 15:51
 **/
public interface AccountMapper {
    /**
     *
     * @param account
     */
    public void save(Account account);

    /**
     * @return
     */
    public List<Account> findAll();
}
