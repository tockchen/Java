package work.ccpw.service;

import work.ccpw.domain.PageBean;
import work.ccpw.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @program: Entry
 * @description: 用户管理的业务接口
 * @author: cone
 * @create: 2020-06-24 13:09
 **/
public interface UserService {

    /**
     * 查询所有用户信息
     * @return list保存user
     */
    public List<User> findAll();

    /**
     * 登录方法
     * @param user  用户信息实体类
     * @return 返回user对象
     */
    public User login(User user);

    /**
     * 保存user对象
     * @param user 返回user对象
     */
    void addUser(User user);

    /**
     * 根据id删除一列
     * @param id 用户id
     */
    void deleteUserById(String id);

    /**
     * 根据id查询用户信息
     * @param id userid
     * @return user
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 删除选中用户信息
     * @param uids 选中id列表
     */
    void delSelectedByid(String[] uids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
