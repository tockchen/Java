package work.ccpw.service.impl;

import work.ccpw.dao.UserDao;
import work.ccpw.dao.impl.UserDaoImpl;
import work.ccpw.domain.PageBean;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @program: Entry
 * @description: 实现类
 * @author: cone
 * @create: 2020-06-24 13:10
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        // 调用Dao完成查询

        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUserById(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        User user = userDao.findUserByid(Integer.parseInt(id));
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedByid(String[] uids) {
        if (uids != null && uids.length > 0) {
            for (String id : uids) {
                userDao.deleteUserById(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1;
        }

        // 1. 创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();


        // 2.调用dao查询总记录数
        int totalCount = userDao.findTotalCount(condition);

        // 3.计算算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        if (currentPage >= totalPage){
            currentPage = totalPage;
        }
        // 4.调用dao查询List集合
        // 计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> userList = userDao.findUserByPage(start, rows,condition);
        // 5.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setUsers(userList);
        pb.setTotalPage(totalPage);

        return pb;
    }


}
