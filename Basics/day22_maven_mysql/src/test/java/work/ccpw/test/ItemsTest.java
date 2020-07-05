package work.ccpw.test;

import org.junit.Test;
import work.ccpw.dao.ItemsDao;
import work.ccpw.dao.impl.ItemsDaoImpl;
import work.ccpw.domain.Items;

import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 16:06
 **/
public class ItemsTest {

    @Test
    public void findAll(){
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> all = itemsDao.findAll();
        System.out.println(all);
    }
}
