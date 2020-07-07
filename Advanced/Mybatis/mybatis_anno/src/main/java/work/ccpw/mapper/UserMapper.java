package work.ccpw.mapper;

import org.apache.ibatis.annotations.*;
import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:03
 **/
public interface UserMapper {

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(int id);

    @Select("select * from user where id = #{id}")
    public User findById(int id);

    @Select("select * from user")
    public List<User> findAll();


    @Select("select * from user")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(
                            property = "orderList",
                            column = "id",
                            javaType = List.class,
                            many = @Many(select = "work.ccpw.mapper.OrderMapper.findByUid")
                    )

            }
    )
    public List<User> findUserAndOrderAll();

    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "work.ccpw.mapper.RoleMapper.findByUid")
            ),
    })
    public List<User>  findUserAndRoleAll();
}
