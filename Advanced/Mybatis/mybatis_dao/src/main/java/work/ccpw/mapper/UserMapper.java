package work.ccpw.mapper;

import work.ccpw.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 14:46
 **/
public interface UserMapper {
    /**
     * 查询所有
     * @return
     * @throws IOException
     */
    public List<User> findAll() throws IOException;

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws IOException
     */
    public User findById(int id) throws IOException;
}
