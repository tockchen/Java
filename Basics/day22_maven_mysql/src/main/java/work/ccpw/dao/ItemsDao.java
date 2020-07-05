package work.ccpw.dao;

import work.ccpw.domain.Items;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 15:45
 **/
public interface ItemsDao {
    public List<Items> findAll();
}
