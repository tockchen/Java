package work.ccpw.service;

import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Entry
 * @description: 用户管理的业务接口
 * @author: cone
 * @create: 2020-06-24 13:09
 **/
public interface UserService {

    public List<User> findAll();
}
