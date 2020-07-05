package work.ccpw.travel.service.impl;

import work.ccpw.travel.dao.UserDao;
import work.ccpw.travel.dao.impl.UserDaoImpl;
import work.ccpw.travel.domain.User;
import work.ccpw.travel.service.UserService;
import work.ccpw.travel.util.MailUtils;
import work.ccpw.travel.util.UuidUtil;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-28 21:05
 **/
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean reqist(User user) {
        // 1. 根据用户名查询用户对象
        User byUsername = userDao.findByUsername(user.getUsername());

        // 判断u是否为null
        if (byUsername != null) {
            // 用户名存在注册失败
            return false;
        }
        // 2. 保存用户信息
        // 2.1 设置激活码,唯一字符串
        user.setCode(UuidUtil.getUuid());
        // 2.2 设置激活状态
        user.setStatus("N");
        userDao.save(user);

        // 3.激活邮件发送,邮件正文
        String content = "<a href='http://localhost/travel/active?code=" + user.getCode() + "'>点击激活[黑马旅游网]</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;

    }

    @Override
    public boolean active(String code) {
        // 1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null) {
            // 2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;

        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
