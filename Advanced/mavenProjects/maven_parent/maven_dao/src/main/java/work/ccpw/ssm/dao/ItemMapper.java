package work.ccpw.ssm.dao;

import work.ccpw.ssm.pojo.Item;

/**
 * @program: mavenProjects
 * @description: 持久层
 * @author: Andy
 * @create: 2020-07-09 16:10
 **/
public interface ItemMapper {

    public Item findById(int id);
}
