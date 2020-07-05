package work.ccpw.service;


/**
 * @author tockc
 */
public interface AccountService {

    /**
     * 交易
     * @param outMan 转出
     * @param inMan 转入
     * @param money 钱
     */
    public void transfer(String outMan,String inMan,double money);

}
