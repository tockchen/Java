package work.ccpw.travel.service;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 15:30
 **/
public interface FavoriteService {

    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    boolean isFavorite(String rid,int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);
}
