package work.ccpw.travel.dao;

import work.ccpw.travel.domain.Seller;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 10:46
 **/
public interface SellerDao {
    /**
     * 根据id查询
     * @param sid
     * @return
     */
    Seller findBysid(int sid);
}
