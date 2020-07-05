package work.ccpw.jedis.dao;

import work.ccpw.jedis.domain.Province;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 10:07
 **/
public interface ProvinceDao {
    public List<Province> findAll();
}
