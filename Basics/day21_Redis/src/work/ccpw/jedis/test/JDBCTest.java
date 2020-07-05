package work.ccpw.jedis.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import work.ccpw.jedis.dao.ProvinceDao;
import work.ccpw.jedis.dao.impl.ProvinceDaoImpl;
import work.ccpw.jedis.domain.Province;
import work.ccpw.jedis.service.ProvinceService;
import work.ccpw.jedis.service.impl.ProvinceServiceImpl;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 10:49
 **/
public class JDBCTest {
    @Test
    public void test() throws JsonProcessingException {
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
}
