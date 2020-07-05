package work.ccpw.jedis.service;

import work.ccpw.jedis.domain.Province;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 10:08
 **/
public interface ProvinceService {
    public List<Province> findAll();

    /**
     * 使用redis缓存
     * @return
     */
    public String findAllJson();
}
