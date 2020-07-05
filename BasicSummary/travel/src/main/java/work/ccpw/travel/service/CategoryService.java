package work.ccpw.travel.service;

import work.ccpw.travel.domain.Category;

import java.util.List;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 16:37
 **/
public interface CategoryService {
    List<Category> findAll();
}
