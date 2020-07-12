package work.ccpw.ssm.service;

import work.ccpw.ssm.pojo.Item;

/**
 * @program: mavenProjects
 * @description:
 * @author: Andy
 * @create: 2020-07-09 16:22
 **/
public interface ItemService {
    public Item findById(int id);
}
