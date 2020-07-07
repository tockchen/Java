package work.ccpw.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import work.ccpw.domain.Order;
import work.ccpw.domain.User;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:23
 **/
public interface OrderMapper {

    /**
     * 查询这个订单属于谁
     * @return order
     */
    @Select("select *,o.id oid from orders o,user u where o.uid = u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password")
    })
    public List<Order> findAll();


    /**
     * 查询这个订单属于谁
     * @return order
     */
    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(

                    /*
                       property: 要封装的属性名称
                       column: 根据那个字段去查询user表的数据
                       javaType: 要封装的实体类型
                       select属性: 代表查询那个接口的方法获得数据
                     */
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "work.ccpw.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAllA();

    @Select("select * from orders")
    public List<Order> findByUid(int uid);
}
