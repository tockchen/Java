package work.ccpw.travel.dao;

import work.ccpw.travel.domain.Favorite;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 15:30
 **/
public interface FavoriteDao {
    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询线路被收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);


    void add(int rid, int uid);
}
