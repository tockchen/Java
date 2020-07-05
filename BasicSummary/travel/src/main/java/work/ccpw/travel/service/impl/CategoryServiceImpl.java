package work.ccpw.travel.service.impl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import work.ccpw.travel.dao.CategoryDao;
import work.ccpw.travel.dao.impl.CategoryDaoImpl;
import work.ccpw.travel.domain.Category;
import work.ccpw.travel.service.CategoryService;
import work.ccpw.travel.util.JedisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-29 16:37
 **/
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        // 1.从redis中查询
        Jedis jedis = JedisUtil.getJedis();
        // 1.2 使用sortedset排序查询
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        // 1.3 查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        // 2.判断查询的集合是否为空
        List<Category> cs = null;
        if (categorys.size() == 0) {
            System.out.println("从数据库查询");
            // 3.如果为空,需要从数据库查询,再将数据存入redis
            // 3.1 从数据库查询
            cs = categoryDao.findAll();
            // 3.2 将集合数据存储到redis中的category的key中
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }
        }else {
            System.out.println("从redis中查询");
            // 4.如果不为空,将set的数据存入list
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();

                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());

                cs.add(category);
            }
        }
        // 4.如果不为空,直接返回

        System.out.println(cs);
        return cs;
    }
}
