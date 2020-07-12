package work.ccpw.ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.ccpw.ssm.dao.ItemMapper;
import work.ccpw.ssm.pojo.Item;
import work.ccpw.ssm.service.ItemService;

/**
 * @program: mavenProjects
 * @description:
 * @author: Andy
 * @create: 2020-07-09 16:23
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public Item findById(int id) {
        return itemMapper.findById(id);
    }
}
