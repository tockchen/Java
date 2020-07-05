package work.ccpw.travel.dao;

import work.ccpw.travel.domain.Category;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 16:31
 **/
public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
