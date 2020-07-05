package work.ccpw.travel.service;

import work.ccpw.travel.domain.User;

/**
 * @program: travel
 * @description:
 * @author: cone
 * @create: 2020-06-28 21:05
 **/
public interface UserService {
    /**
     * 注册用户
     */
    boolean reqist(User user);

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 登录验证
     * @param user
     * @return
     */
    User login(User user);
}
