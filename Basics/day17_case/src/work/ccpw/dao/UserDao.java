package work.ccpw.dao;

import work.ccpw.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @program: Entry
 * @description: 用户操作的DAO
 * @author: cone
 * @create: 2020-06-24 13:11
 **/
public interface UserDao {
    /**
     *  查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 比较用户名或密码是否一致
     * @param username 用户名
     * @param password 密码
     * @return user对象
     */
    public User findUserByUsernameAndPassword(String username,String password);

    /**
     * 添加用户
     * @param user user对象
     */
    void add(User user);

    /**
     * 删除一列
     * @param id  uerid
     */
    void deleteUserById(int id);

    /**
     * 根据id查询
     * @param id userid
     * @return user
     */
    User findUserByid(int id);

    /**
     * 根据id修改用户信息
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findUserByPage(int start, int rows, Map<String, String[]> condition);
}
