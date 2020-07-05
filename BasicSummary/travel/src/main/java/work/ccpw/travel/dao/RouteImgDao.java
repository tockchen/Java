package work.ccpw.travel.dao;

import work.ccpw.travel.domain.RouteImg;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-30 10:37
 **/
public interface RouteImgDao {

    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    List<RouteImg>  findByRid(int rid);
}
