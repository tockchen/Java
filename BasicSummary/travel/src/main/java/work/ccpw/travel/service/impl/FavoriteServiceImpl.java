package work.ccpw.travel.service.impl;

import work.ccpw.travel.dao.FavoriteDao;
import work.ccpw.travel.dao.impl.FavoriteDaoImpl;
import work.ccpw.travel.domain.Favorite;
import work.ccpw.travel.service.FavoriteService;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 15:30
 **/
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
