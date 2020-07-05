package work.ccpw.service.impl;

import work.ccpw.dao.RoleDao;
import work.ccpw.dao.UserDao;
import work.ccpw.domain.Role;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;

import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-04 14:46
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        // 查询用户信息表
        List<User> userList = userDao.findAll();
        // 封装userList中的每个User中的roles数据
        for (User user : userList) {
            // 获得userId
            Long id = user.getId();
            // 将id作为参数 查询当前对应的role集合数据
            List<Role> roles = roleDao.findRoleByUserId(user.getId());
            user.setRoles(roles);
        }


        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        // 第一张表先向sys_user表中存储数据
        Long userId = userDao.save(user);
        // 第二张表
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(String userId) {
        // 删除关系表
        userDao.delUserRoleRel(userId);
        // 删除用户表
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = userDao.findByUsrenameAndPassword(username,password);
            return user;
        } catch (Exception e) {
            return null;
        }

    }
}
