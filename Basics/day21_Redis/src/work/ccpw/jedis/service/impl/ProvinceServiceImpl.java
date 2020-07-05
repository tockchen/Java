package work.ccpw.jedis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import work.ccpw.jedis.dao.ProvinceDao;
import work.ccpw.jedis.dao.impl.ProvinceDaoImpl;
import work.ccpw.jedis.domain.Province;
import work.ccpw.jedis.service.ProvinceService;
import work.ccpw.jedis.utils.JedisPoolUtils;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 10:09
 **/
public class ProvinceServiceImpl implements ProvinceService {

    // 声明dao
    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public String findAllJson() {
        // 1.先从redis中查询数据
        // 1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        // 2.判断 province_json 数据是否为null
        if (province_json == null || province_json.length() == 0) {
            // redis中没有数据
            System.out.println("redis中没数据,查询数据库...");

            // 2.1从数据中查询
            List<Province> ps = provinceDao.findAll();
            // 2.2 将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // 2.3 将json数据存入redis中
            jedis.set("province",province_json);
        }else {
            System.out.println("redis中有数据,查询缓存...");
        }
        return province_json;
    }
}
