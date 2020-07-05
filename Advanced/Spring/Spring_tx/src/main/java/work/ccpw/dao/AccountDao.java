package work.ccpw.dao;

/**
 * @author Andy
 */
public interface AccountDao {

    /**
     * 转出
     * @param outMan
     * @param money
     */
    public void out(String outMan,double money);

    /**
     * 转入
     * @param inMan
     * @param money
     */
    public void in(String inMan,double money);

    public void save();
}
